import java.util.*;

public class CloudApplication {
    public static void main(String[] args) {
        UserService users = new UserService();
        StorageService storage = new StorageService();

        users.createUser("101", "Alex");
        storage.save("101", "profile-data");

        System.out.println(users.getUser("101"));
        System.out.println(storage.fetch("101"));
    }
}