import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StubbingBehaviorTest {

    @Test
    void testStub() {
        UserRepository repo = mock(UserRepository.class);
        when(repo.getName()).thenReturn("Vineela");

        UserService service = new UserService(repo);

        assertEquals("Vineela", service.fetchUser());
    }
}
