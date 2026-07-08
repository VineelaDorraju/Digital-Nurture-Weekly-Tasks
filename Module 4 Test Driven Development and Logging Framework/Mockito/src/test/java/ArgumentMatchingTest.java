import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class ArgumentMatchingTest {

    @Test
    void testArgumentMatcher() {
        UserRepository repo = mock(UserRepository.class);

        UserService service = new UserService(repo);
        service.save("Vineela");

        verify(repo).saveUser(anyString());
    }
}
