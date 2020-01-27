/*
 * Copyright (c) E-System LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2020
 */

package com.es.cloudapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Vitaliy Savchenko - savchenko.v@ext-system.com
 * @since 12.07.18
 */
@Profile({"develop"})
@Configuration
public class DevelopHandlerConfig extends WebMvcConfigurerAdapter {

    @Value("${project.root}")
    private String projectRoot;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:" + projectRoot + "/src/main/resources/static/");
    }
}
