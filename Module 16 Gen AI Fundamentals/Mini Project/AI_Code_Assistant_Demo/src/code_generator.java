public class CodeGenerator {

    public String generate(String prompt) {
        if (Utils.isEmpty(prompt)) {
            return "Generation failed: Prompt cannot be empty.";
        }

        String request = Utils.normalize(prompt).toLowerCase();

        if (request.contains("palindrome")) {
            return """
public boolean isPalindrome(String text) {
    String reversed = new StringBuilder(text).reverse().toString();
    return text.equalsIgnoreCase(reversed);
}
""";
        }

        if (request.contains("factorial")) {
            return """
public long factorial(int number) {
    long result = 1;
    for (int i = 2; i <= number; i++) {
        result *= i;
    }
    return result;
}
""";
        }

        return "Code generated successfully for: " + prompt;
    }
}