public class PromptEngine {

    public String prepare(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            return "No prompt provided.";
        }

        return "Developer Request: " + prompt.trim();
    }
}