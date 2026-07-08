import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemoTest {

    @Test
    void testAdd(){
        AssertionsDemo demo=new AssertionsDemo();
        assertEquals(10,demo.add(4,6));
    }
}
