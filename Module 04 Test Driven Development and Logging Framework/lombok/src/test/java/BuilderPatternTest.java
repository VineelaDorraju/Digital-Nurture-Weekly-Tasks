import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderPatternTest {

    @Test
    void testBuilder() {
        BuilderPattern obj=BuilderPattern.builder().id(1).name("Vineela").build();
        assertNotNull(obj);
    }
}
