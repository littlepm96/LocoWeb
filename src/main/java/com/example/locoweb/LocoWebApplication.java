package com.example.locoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

@SpringBootApplication
@EnableWebMvc
@AutoConfiguration
@ComponentScan(basePackages = {"controller", "model", "service", "microservice"})
public class LocoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocoWebApplication.class, args);
    }

}
