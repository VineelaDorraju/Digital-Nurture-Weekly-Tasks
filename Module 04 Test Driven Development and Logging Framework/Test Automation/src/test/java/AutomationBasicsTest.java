import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AutomationBasicsTest {

    @Test
    void testTool() {
        AutomationBasics obj = new AutomationBasics();
        assertEquals("JUnit", obj.tool());
    }
}
