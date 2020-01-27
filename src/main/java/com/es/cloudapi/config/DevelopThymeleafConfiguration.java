/*
 * Copyright (c) E-System LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2020
 */

package com.es.cloudapi.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;


/**
 * @author Vitaliy Savchenko - savchenko.v@ext-system.com
 * @since 12.07.18
 */
@Profile({"develop"})
@Configuration
public class DevelopThymeleafConfiguration {

    private ThymeleafProperties properties;

    @Value("${spring.thymeleaf.templatesRoot}")
    private String templatesRoot;

    @Value("${project.root}")
    private String projectRoot;

    @Bean
    public FileTemplateResolver templateResolver() {
        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setTemplateMode(properties.getMode());
        resolver.setCharacterEncoding(properties.getEncoding().toString());
        resolver.setCacheable(properties.isCache());
        resolver.setPrefix(projectRoot + templatesRoot);
        resolver.setSuffix(properties.getSuffix());
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.addDialect(new SpringSecurityDialect());
        templateEngine.addTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Autowired
    public void setProperties(ThymeleafProperties properties) {
        this.properties = properties;
    }

}
