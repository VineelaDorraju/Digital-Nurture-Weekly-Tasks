import java.util.*;

public class LambdaFunctionSimulator {
    interface Lambda {
        String handle(String input);
    }

    public static void main(String[] args) {
        Lambda fn = input -> input.toUpperCase();

        List<String> events = List.of("login", "upload", "delete");

        events.stream()
              .map(fn::handle)
              .forEach(System.out::println);
    }
}