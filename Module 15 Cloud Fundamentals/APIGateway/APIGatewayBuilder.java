import java.util.*;

public class APIGatewayBuilder {
    static class API {
        String name;
        Map<String, String> routes = new HashMap<>();

        API(String name) {
            this.name = name;
        }

        void addRoute(String path, String method) {
            routes.put(path, method);
        }

        public String toString() {
            return name + " " + routes;
        }
    }

    public static void main(String[] args) {
        API api = new API("user-api");
        api.addRoute("/users", "GET");
        api.addRoute("/users", "POST");

        System.out.println(api);
    }
}