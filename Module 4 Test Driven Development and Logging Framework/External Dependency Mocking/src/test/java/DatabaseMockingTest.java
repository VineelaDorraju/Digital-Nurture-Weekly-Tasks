import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseMockingTest {

    @Test
    void testDatabase() {
        DatabaseService service = new DatabaseService();
        assertEquals("Database Record", service.fetchData());
    }
}
