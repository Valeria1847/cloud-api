package com.es.cloudapi.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public AuthenticationFailureHandler() {
    }

    public AuthenticationFailureHandler(String defaultFailureUrl) {
        super(defaultFailureUrl);
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null || this.isAllowSessionCreation()) {
            request.getSession().setAttribute("SPRING_SECURITY_LAST_USERNAME", request.getParameter("phone"));
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}
