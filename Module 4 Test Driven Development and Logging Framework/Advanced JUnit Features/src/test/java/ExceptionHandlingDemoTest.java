import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ExceptionHandlingDemoTest{
@Test
void testException(){
assertThrows(ArithmeticException.class,()->new ExceptionHandlingDemo().divide(10,0));
}
}
