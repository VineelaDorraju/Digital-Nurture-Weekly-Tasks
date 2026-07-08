import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImmutableClassesTest {

    @Test
    void testValue() {
        ImmutableClasses obj=new ImmutableClasses(1,"Vineela");
        assertEquals("Vineela",obj.getName());
    }
}
