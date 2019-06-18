package com.es.cloudapi.service.security;

import com.es.cloudapi.entity.access.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityPerson extends Person implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;

    public SecurityPerson(Integer id, boolean active, String login, String email, String name, String surname, String patronymic, String passwordHash, short incorrectLoginCount, boolean blockedPassword, boolean blockedAdmin, Collection<? extends GrantedAuthority> authorities) {
        super(id, active, login, email, name, surname, patronymic, passwordHash, incorrectLoginCount, blockedPassword, blockedAdmin);
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() { return super.getPasswordHash(); }

    @Override
    public String getUsername() { return super.getLogin(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return !(super.isBlockedAdmin() || super.isBlockedPassword()); }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return super.isActive(); }

}
