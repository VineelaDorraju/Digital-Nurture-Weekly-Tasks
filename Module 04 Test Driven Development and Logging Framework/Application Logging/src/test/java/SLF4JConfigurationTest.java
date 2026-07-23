import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SLF4JConfigurationTest {

    @Test
    void testConfiguration() {
        SLF4JConfiguration obj=new SLF4JConfiguration();
        assertEquals("SLF4J Configured",obj.configure());
    }
}
