package org.edu.fabs.qrcodegenerator.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        return new OpenAPI().info(new Info().title("QRCode Generator for WIFI login")
                .description("This API exposes endpoints to manage qrcode for wifi.")
                .version("0.0.1")
                .contact(new Contact().name("FabFerlin")
                        .url("https://github.com/bianavic"))
                .license(new License().name("MIT License").url("https://choosealicense.com/licenses/mit/")));
    }
}
