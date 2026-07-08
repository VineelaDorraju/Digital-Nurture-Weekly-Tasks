import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestTypesTest {

    @Test
    void testType() {
        TestTypes obj = new TestTypes();
        assertEquals("Unit Test", obj.type());
    }
}
