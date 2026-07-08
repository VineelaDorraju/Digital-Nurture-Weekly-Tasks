import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class VoidMethodTestingTest {

    @Test
    void testVoidMethod() {
        UserRepository repo = mock(UserRepository.class);

        doNothing().when(repo).saveUser("Vineela");

        UserService service = new UserService(repo);
        service.save("Vineela");

        verify(repo).saveUser("Vineela");
    }
}
