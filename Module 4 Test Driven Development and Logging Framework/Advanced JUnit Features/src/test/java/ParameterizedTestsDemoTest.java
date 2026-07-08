import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
public class ParameterizedTestsDemoTest{
@ParameterizedTest
@ValueSource(ints={1,2,3})
void testPositive(int n){
assertTrue(new ParameterizedTestsDemo().isPositive(n));
}
}
