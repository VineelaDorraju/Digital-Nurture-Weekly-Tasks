import java.util.*;

public class DynamoDBTableManager {
    static class Table {
        String name;
        Map<String, String> data = new HashMap<>();

        Table(String name) {
            this.name = name;
        }

        void put(String key, String value) {
            data.put(key, value);
        }

        String get(String key) {
            return data.getOrDefault(key, "not-found");
        }
    }

    public static void main(String[] args) {
        Table users = new Table("Users");
        users.put("101", "Alice");
        users.put("102", "Bob");

        System.out.println(users.get("101"));
        System.out.println(users.get("999"));
    }
}