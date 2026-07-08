import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MockCreationTest {

    @Test
    void createMock() {
        UserRepository repo = mock(UserRepository.class);
        assertNotNull(repo);
    }
}
