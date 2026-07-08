import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CucumberBasicsTest {

    @Test
    void testFeature() {
        CucumberBasics obj = new CucumberBasics();
        assertEquals("Login Feature", obj.feature());
    }
}
