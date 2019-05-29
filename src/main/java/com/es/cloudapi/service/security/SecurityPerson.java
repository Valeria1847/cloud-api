//package com.es.cloudapi.service.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class SecurityPerson implements UserDetails {
//
//    private Collection<? extends GrantedAuthority> authorities;
//    private Integer idCity;
////
////    public SecurityPerson(Integer id, String name, String surname, String email, String phone, String passwordHash, short incorrectLoginCount, boolean blockedPassword, boolean active, Map<String, String> attributes, Collection<? extends GrantedAuthority> authorities, City city) {
////        super(id, name, surname, email, phone, passwordHash, incorrectLoginCount, blockedPassword, active, attributes, city);
////        this.authorities = authorities;
////        this.idCity = IPrimaryKey.getNullOrId(city);
////    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() { return null; }
//
//    @Override
//    public String getUsername() { return null; }
//
//    @Override
//    public boolean isAccountNonExpired() { return false; }
//
//    @Override
//    public boolean isAccountNonLocked() { return false; }
//
//    @Override
//    public boolean isCredentialsNonExpired() { return false; }
//
//    @Override
//    public boolean isEnabled() { return false; }
//
////    @Override
////    public String getPassword() {
////        return getPasswordHash();
////    }
////
////    @Override
////    public String getUsername() {
////        return getPhone();
////    }
////
////    @Override
////    public boolean isAccountNonExpired() {
////        return true;
////    }
////
////    @Override
////    public boolean isAccountNonLocked() {
////        return !isBlockedPassword();
////    }
////
////    @Override
////    public boolean isCredentialsNonExpired() {
////        return true;
////    }
////
////    @Override
////    public boolean isEnabled() {
////        return isActive();
////    }
////
////    public Integer getIdCity() { return idCity; }
//}
