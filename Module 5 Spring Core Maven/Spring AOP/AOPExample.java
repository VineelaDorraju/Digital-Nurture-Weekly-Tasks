import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

// configuration class
@Configuration
@ComponentScan(basePackages = "")
@EnableAspectJAutoProxy
class AppConfig {
}

public class AOPExample {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ServiceClass service = context.getBean(ServiceClass.class);

        service.processTask();
        System.out.println();

        service.generateReport();
    }
}