package xyz.rbulatov.order.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Orders Swagger Api")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("tima_west@mail.ru")
                                                .url("https://tima_west.ru")
                                                .name("Bulatov Ruslan")
                                )
                );
    }


}