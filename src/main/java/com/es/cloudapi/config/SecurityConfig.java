package com.es.cloudapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService authService;
    private ApplicationEventPublisher eventPublisher;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/cabinet/**", "/settings").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .successHandler(successLoginHandler())
            .defaultSuccessUrl("/cabinet")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .deleteCookies("remember-me")
            .permitAll()
            .and()
            .rememberMe();
    }

    @Bean
    public AuthenticationSuccessHandler successLoginHandler() {
        AuthenticationSuccessHandler result = new AuthenticationSuccessHandler(eventPublisher);
        result.setUseReferer(true);
        return result;
    }

    @Bean
    public AuthenticationFailureHandler failureLoginHandler() {
        return new AuthenticationFailureHandler("/login");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/css/")
            .antMatchers("/js/")
            .antMatchers("/fonts/")
            .antMatchers("/icons/")
            .antMatchers("/images/")
            .antMatchers("/html/");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Autowired
    public void setAuthService(UserDetailsService authService) {
        this.authService = authService;
    }

    @Autowired
    public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
}