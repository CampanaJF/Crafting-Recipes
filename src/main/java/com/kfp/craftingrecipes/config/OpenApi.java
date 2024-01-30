package com.kfp.craftingrecipes.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Franco",
                        email = "fcampana@mobydigital.com",
                        url = "http://localhost:8080/swagger-ui/index.html"
                ),
                description = "OpenAPI documentation for bookstore this spring boot application is" +
                        " for testing and implementing new concepts for fun.",
                title = "Crafting Recipes - Franco",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "local environment",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApi {
}
