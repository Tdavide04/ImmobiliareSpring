package com.gestione.Immobiliare.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Immobiliare API")
                        .version("v0.0.1")
                        .description("API documentation for Immobiliare")
                        .contact(new Contact().name("Davide Trischitta").email("tdavide833@gmail.com")));
    }
}
