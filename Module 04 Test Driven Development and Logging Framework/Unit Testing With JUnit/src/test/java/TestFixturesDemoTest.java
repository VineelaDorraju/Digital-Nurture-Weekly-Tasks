import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFixturesDemoTest {

    @Test
    void testAvailable(){
        TestFixturesDemo demo=new TestFixturesDemo();
        assertTrue(demo.isAvailable());
    }
}
