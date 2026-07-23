import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestLifecycleDemoTest {

    TestLifecycleDemo demo;

    @BeforeEach
    void setUp(){
        demo=new TestLifecycleDemo();
    }
    @Test
    void testMessage(){
        assertEquals("JUnit Lifecycle",demo.message());
    }
}
