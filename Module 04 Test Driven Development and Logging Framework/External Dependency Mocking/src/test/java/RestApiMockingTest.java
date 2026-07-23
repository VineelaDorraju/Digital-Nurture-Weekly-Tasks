import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestApiMockingTest {

    @Test
    void testApi() {
        ApiService service = new ApiService();
        assertEquals("API Response", service.getResponse());
    }
}
