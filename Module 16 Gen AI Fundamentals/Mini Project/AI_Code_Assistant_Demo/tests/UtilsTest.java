import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void shouldNormalizeSpaces() {
        String text = "  AI     Code   Assistant  ";
        assertEquals("AI Code Assistant", Utils.normalize(text));
    }

    @Test
    void shouldIdentifyEmptyText() {
        assertTrue(Utils.isEmpty("   "));
        assertFalse(Utils.isEmpty("Java"));
    }
}