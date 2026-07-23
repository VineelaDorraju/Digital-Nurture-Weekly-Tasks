import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedLoggingTest {

    @Test
    void testMessage() {
        ParameterizedLogging obj=new ParameterizedLogging();
        assertEquals("Welcome Vineela",obj.message("Vineela"));
    }
}
