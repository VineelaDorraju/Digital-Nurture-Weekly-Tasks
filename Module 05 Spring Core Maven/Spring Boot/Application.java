import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        // start Spring Boot application
        ApplicationContext context = SpringApplication.run(App.class, args);

        // get bean from container
        BootEx service = context.getBean(BootEx.class);

        service.runApp();
    }
}