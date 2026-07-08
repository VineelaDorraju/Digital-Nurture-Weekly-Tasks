import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FrameworkDesignTest {

    @Test
    void testFramework() {
        FrameworkDesign obj = new FrameworkDesign();
        assertEquals("Hybrid Framework", obj.framework());
    }
}
