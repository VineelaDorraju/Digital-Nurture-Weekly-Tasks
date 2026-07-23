import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoreAnnotationsTest {

    @Test
    void testObject() {
        CoreAnnotations obj=new CoreAnnotations();
        obj.setId(1);
        obj.setName("Vineela");
        assertEquals("Vineela",obj.getName());
    }
}
