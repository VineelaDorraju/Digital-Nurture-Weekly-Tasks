import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    @Test
    void testService() {
        StudentRepository repo = () -> "Vineela";
        StudentService service = new StudentService(repo);
        assertEquals("Vineela", service.fetchStudent());
    }
}
