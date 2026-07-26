import java.util.*;

public class LambdaIntegration {
    static Map<String, String> db = new HashMap<>();

    static String invoke(String action, String key, String value) {
        switch (action) {
            case "PUT":
                db.put(key, value);
                return "stored";
            case "GET":
                return db.getOrDefault(key, "missing");
            default:
                return "invalid";
        }
    }

    public static void main(String[] args) {
        System.out.println(invoke("PUT", "id1", "data"));
        System.out.println(invoke("GET", "id1", ""));
        System.out.println(invoke("GET", "id2", ""));
    }
}