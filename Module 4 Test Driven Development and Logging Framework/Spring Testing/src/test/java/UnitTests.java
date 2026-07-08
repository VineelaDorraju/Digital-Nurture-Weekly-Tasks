import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    @Test
    void testWelcome() {
        StudentController controller = new StudentController();
        assertEquals("Welcome", controller.welcome());
    }
}
