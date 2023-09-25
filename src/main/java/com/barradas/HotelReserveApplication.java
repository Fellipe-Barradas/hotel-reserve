package com.barradas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
        info = @Info(title = "Hotel Reserve API",
        version = "1.0",
        description = "Documentation Hotel Reserve API v1.0"),
        servers = {
                @Server(url = "/", description = "Local server")
        }
)
@SecurityScheme(
        name = "swaggerapi",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class HotelReserveApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelReserveApplication.class, args);
    }

}
