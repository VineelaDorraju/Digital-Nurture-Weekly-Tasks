import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggingLevelsTest {

    @Test
    void testLevel() {
        LoggingLevels obj=new LoggingLevels();
        assertEquals("INFO",obj.level());
    }
}
