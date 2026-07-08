import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SeleniumExampleTest {

    @Test
    void testBrowser() {
        SeleniumExample obj = new SeleniumExample();
        assertEquals("Chrome", obj.browser());
    }
}
