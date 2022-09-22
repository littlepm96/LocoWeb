package com.example.locoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

@SpringBootApplication
public class LocoWebApplication {

    private final TemplateEngine templateEngine;

    public LocoWebApplication(final ServletContext servletContext){
        super();
        //Setup del template engine
        ServletContextTemplateResolver templateResolver =
                new ServletContextTemplateResolver(servletContext);

        templateResolver.setTemplateMode(TemplateMode.HTML);
        // Converte "home" a "/WEB-INF/templates/home.html"
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // Mantieni template in cache per 1 ora.
        templateResolver.setCacheTTLMs(3600000L);

        templateResolver.setCacheable(true);

        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);
    }

    public static void main(String[] args) {
        SpringApplication.run(LocoWebApplication.class, args);
    }

}
