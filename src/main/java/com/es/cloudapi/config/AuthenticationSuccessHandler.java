package com.es.cloudapi.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public AuthenticationSuccessHandler(ApplicationEventPublisher eventPublisher) {
    }

}