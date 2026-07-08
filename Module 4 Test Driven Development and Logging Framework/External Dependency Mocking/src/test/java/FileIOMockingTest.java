import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileIOMockingTest {

    @Test
    void testFile() {
        FileService service = new FileService();
        assertEquals("File Content", service.readFile());
    }
}
