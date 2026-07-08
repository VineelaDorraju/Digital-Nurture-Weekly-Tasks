import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExecutionControlDemoTest{
@Test @Order(1)
void testRun(){
assertEquals("Executed",new ExecutionControlDemo().run());
}
}
