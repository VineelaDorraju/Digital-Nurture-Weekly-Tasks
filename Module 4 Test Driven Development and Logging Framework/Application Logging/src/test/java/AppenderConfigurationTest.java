import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppenderConfigurationTest {

    @Test
    void testAppender() {
        AppenderConfiguration obj=new AppenderConfiguration();
        assertEquals("Console Appender",obj.appender());
    }
}
