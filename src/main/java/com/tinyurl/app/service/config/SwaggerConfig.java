package com.tinyurl.app.service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI tinyUrlOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TinyURL Service API")
                        .description("CRUD operations for URL shortening like Bitly")
                        .version("1.0.0"));
    }
}
