import java.util.*;

public class StorageService {
    private Map<String, String> storage = new HashMap<>();

    public void save(String key, String value) {
        storage.put(key, value);
    }

    public String fetch(String key) {
        return storage.getOrDefault(key, "empty");
    }
}