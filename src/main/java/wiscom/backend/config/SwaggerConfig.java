package wiscom.backend.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI WiscomSwaggerAPI() {
        Info info = new Info()
                .title("2025 WISCOM backend API")
                .description("2025 WISCOM backend API 명세서")
                .version("1.0.0");

        return new OpenAPI()
                .info(info);
    }
}