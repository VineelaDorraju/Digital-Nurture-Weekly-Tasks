import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentServiceTest {

    @Test
    void testStudentName() {

        StudentService service = new StudentService();
        assertEquals("Vineela", service.getStudentName());

    }
}