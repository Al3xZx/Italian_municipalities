package com.github.al3xzx.italian_municipalities.configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Value("${OpenApi.serverUrl}")
  private String serverUrl;

  @Value("${OpenApi.serverDescription}")
  private String serverDescription;

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .addServersItem(new Server().url(serverUrl).description(serverDescription))
        .info(new Info().title("Italian Municipalities API")
            .description("Italian municipalities")
            .version("v0.0.1")
            .license(new License()
                .name("Apache 3.0")
                .url("https://github.com/Al3xZx/Italian_municipalities/blob/master/LICENSE")
            ))
        .externalDocs(new ExternalDocumentation()
            .description("Italian municipalities GitHub repository")
            .url("https://github.com/Al3xZx/Italian_municipalities"));
  }
}
