import org.springframework.stereotype.Component;

@Component
public class BootEx {

    public void runApp() {
        System.out.println("Spring Boot application is running successfully!");
        showFeatures();
    }

    private void showFeatures() {
        System.out.println("Auto Configuration Enabled");
        System.out.println("No XML Configuration Needed");
        System.out.println("Embedded Server Ready");
    }
}