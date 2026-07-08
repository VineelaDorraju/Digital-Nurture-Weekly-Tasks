import org.junit.jupiter.api.Test;

public class Slf4jAnnotationTest {

    @Test
    void testLog() {
        Slf4jAnnotation obj=new Slf4jAnnotation();
        obj.showMessage();
    }
}
