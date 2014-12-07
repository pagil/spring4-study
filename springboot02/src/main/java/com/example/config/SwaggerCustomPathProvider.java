package com.example.config;

import com.mangofactory.swagger.controllers.DefaultSwaggerController;
import com.mangofactory.swagger.paths.RelativeSwaggerPathProvider;

import javax.servlet.ServletContext;

public class SwaggerCustomPathProvider extends RelativeSwaggerPathProvider {

    private String docsLocation;

    public SwaggerCustomPathProvider(ServletContext servletContext, String docsLocation) {
        super(servletContext);
        this.docsLocation = docsLocation;
    }

    @Override
    public String getDocumentationPath() {
        return applicationPath() + docsLocation + DefaultSwaggerController.DOCUMENTATION_BASE_PATH;
    }
}