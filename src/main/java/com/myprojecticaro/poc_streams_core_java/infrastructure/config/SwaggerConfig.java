package com.myprojecticaro.poc_streams_core_java.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
        title = "Java Streams POC API",
        version = "1.0",
        description = "A simple API demonstrating Java Stream operations and functional interfaces"
    )
)
@Configuration
public class SwaggerConfig {
}
