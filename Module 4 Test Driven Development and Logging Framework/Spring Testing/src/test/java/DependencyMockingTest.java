import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DependencyMockingTest {

    @Test
    void testMocking() {
        StudentRepository repo = mock(StudentRepository.class);
        when(repo.getStudentName()).thenReturn("Vineela");
        StudentService service = new StudentService(repo);
        assertEquals("Vineela", service.fetchStudent());
    }
}
