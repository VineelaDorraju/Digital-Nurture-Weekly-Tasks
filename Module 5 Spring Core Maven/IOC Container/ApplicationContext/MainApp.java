import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
class AppConfig {

    @Bean
    Subject subject() {
        return new Subject("Data Structures");
    }

    @Bean
    Teacher teacher() {
        return new Teacher(subject());
    }
}

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Teacher t = context.getBean(Teacher.class);
        t.teach();
    }
}