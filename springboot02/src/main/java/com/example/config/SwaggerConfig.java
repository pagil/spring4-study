package com.example.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.paths.SwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

@Configuration
@EnableSwagger()
public class SwaggerConfig {

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    private ServletContext servletContext;

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        SwaggerPathProvider defaultSwaggerPathProvider = new SwaggerCustomPathProvider(servletContext, "/version1/");
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
                apiInfo()).includePatterns("/.*").pathProvider(defaultSwaggerPathProvider);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Launcher API", "API for Launcher",
                "Launcher API terms of service", "Launcher@test.com",
                "Launcher API Licence Type", "Launcher API License URL");
        return apiInfo;
    }
}
