import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoDemoTest {

    @Test
    void testDisplayUser() {

        RepositoryMock repository = mock(RepositoryMock.class);
        when(repository.getUserName()).thenReturn("Vineela");
        
        MockitoDemo demo = new MockitoDemo(repository);

        assertEquals("Vineela", demo.displayUser());
        verify(repository).getUserName();

    }
}