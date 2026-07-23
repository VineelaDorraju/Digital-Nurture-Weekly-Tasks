import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class InteractionVerificationTest {

    @Test
    void verifyMethodCall() {
        UserRepository repo = mock(UserRepository.class);

        UserService service = new UserService(repo);
        service.fetchUser();

        verify(repo).getName();
    }
}
