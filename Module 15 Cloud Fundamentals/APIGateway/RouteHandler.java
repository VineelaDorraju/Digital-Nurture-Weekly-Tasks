import java.util.*;

public class RouteHandler {
    public static void main(String[] args) {
        Map<String, Runnable> routes = new HashMap<>();

        routes.put("/home", () -> System.out.println("Home"));
        routes.put("/login", () -> System.out.println("Login"));

        String request = "/login";

        routes.getOrDefault(request, () -> System.out.println("404")).run();
    }
}