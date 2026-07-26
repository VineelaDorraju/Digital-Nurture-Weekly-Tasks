import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CodeReviewerTest {

    private final CodeReviewer reviewer = new CodeReviewer();

    @Test
    void shouldReviewConsoleCode() {
        String code = "System.out.println(\"Hello\");";
        String result = reviewer.review(code);
        assertTrue(result.contains("Review completed"));
    }

    @Test
    void shouldHandleEmptyCode() {
        String result = reviewer.review("");
        assertEquals("Review failed: No source code provided.", result);
    }
}