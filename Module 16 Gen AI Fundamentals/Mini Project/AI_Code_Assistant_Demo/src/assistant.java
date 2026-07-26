public class AICodeAssistant {

    private final PromptEngine promptEngine = new PromptEngine();
    private final CodeGenerator codeGenerator = new CodeGenerator();

    public String generateResponse(String prompt) {
        String formattedPrompt = promptEngine.prepare(prompt);
        return codeGenerator.generate(formattedPrompt);
    }
}