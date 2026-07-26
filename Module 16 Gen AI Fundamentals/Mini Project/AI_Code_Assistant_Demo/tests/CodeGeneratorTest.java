import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CodeGeneratorTest {

    private final CodeGenerator generator = new CodeGenerator();

    @Test
    void shouldGeneratePalindromeMethod() {
        String result = generator.generate("Create a palindrome function");
        assertTrue(result.contains("isPalindrome"));
    }

    @Test
    void shouldRejectEmptyPrompt() {
        String result = generator.generate("");
        assertEquals("Generation failed: Prompt cannot be empty.", result);
    }
}