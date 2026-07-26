import java.util.*;

public class NotificationLambda {
    public static void main(String[] args) {
        List<String> events = List.of("user_created", "file_uploaded");

        events.forEach(e -> {
            if (e.contains("user")) {
                System.out.println("Notify admin: " + e);
            } else {
                System.out.println("Log event: " + e);
            }
        });
    }
}