import org.springframework.stereotype.Component;

@Component
public class ServiceClass {

    public void processTask() {
        System.out.println("Processing task in service class...");
    }

    public void generateReport() {
        System.out.println("Generating report...");
    }
}