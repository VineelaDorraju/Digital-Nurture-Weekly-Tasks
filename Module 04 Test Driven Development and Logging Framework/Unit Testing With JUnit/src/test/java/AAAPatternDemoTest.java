import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AAAPatternDemoTest {

    @Test
    void testGreeting(){

        // Arrange
        AAAPatternDemo demo=new AAAPatternDemo();
        // Act
        String result=demo.greet("Vineela");
        // Assert
        assertEquals("Hello Vineela",result);
    }
}
