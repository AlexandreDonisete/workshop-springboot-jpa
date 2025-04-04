package com.educandoweb.course.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API DOCUMENTATION",
                version = "1.0",
                description = "API DOCUMENTATION"
        )
)
public class OpenApiConfig {

}
