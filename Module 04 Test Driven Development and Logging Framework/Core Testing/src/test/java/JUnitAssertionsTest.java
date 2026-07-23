import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JUnitAssertionsTest {

    @Test
    void testAddition() {
        JUnitAssertions obj = new JUnitAssertions();
        assertEquals(15, obj.add(10, 5));

    }

    @Test
    void testPositiveNumber() {

        JUnitAssertions obj = new JUnitAssertions();
        assertTrue(obj.isPositive(20));
        assertFalse(obj.isPositive(-5));

    }
}