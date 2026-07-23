import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestSuitesDemoTest{
@Test
void testSuite(){
assertEquals("JUnit Suite",new TestSuitesDemo().suite());
}
}
