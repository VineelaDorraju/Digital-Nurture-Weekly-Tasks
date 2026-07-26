import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AICodeAssistant assistant = new AICodeAssistant();

        System.out.println("=== AI Code Assistant Demo ===");
        System.out.print("Enter your prompt: ");

        String prompt = scanner.nextLine();

        String response = assistant.generateResponse(prompt);

        System.out.println("\nGenerated Response:");
        System.out.println(response);

        scanner.close();
    }
}