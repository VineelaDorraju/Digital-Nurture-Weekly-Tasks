import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkMockingTest {

    @Test
    void testNetwork() {
        NetworkService service = new NetworkService();
        assertEquals("Connected", service.connect());
    }
}
