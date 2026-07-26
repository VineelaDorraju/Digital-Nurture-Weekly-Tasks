import java.util.*;

public class UserService {
    private Map<String, String> users = new HashMap<>();

    public void createUser(String id, String name) {
        users.put(id, name);
    }

    public String getUser(String id) {
        return users.getOrDefault(id, "unknown");
    }
}