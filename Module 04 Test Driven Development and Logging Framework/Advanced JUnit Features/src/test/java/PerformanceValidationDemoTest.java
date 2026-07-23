import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
public class PerformanceValidationDemoTest{
@Test
void testPerformance(){
assertTimeout(Duration.ofSeconds(1),()->new PerformanceValidationDemo().process());
}
}
