package com.github.al3xzx.italian_municipalities.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .addServersItem(new Server().url("http://localhost:8080").description("develop server"))
        .info(new Info().title("Italian Municipalities API")
            .description("Italian municipalities")
            .version("v0.0.1"));
  }
}
