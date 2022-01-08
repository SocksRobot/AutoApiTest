import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@ComponentScan("com.xrayng")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
