import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitParameterizedTestsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testEvenNumbers(int number) {

        JUnitParameterizedTests obj = new JUnitParameterizedTests();

        assertTrue(obj.isEven(number));

    }
}