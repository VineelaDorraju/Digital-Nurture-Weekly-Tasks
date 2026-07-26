import java.util.*;

public class KeyPairSimulation {
    static class KeyPair {
        String name;
        String publicKey;
        String privateKey;

        KeyPair(String name) {
            this.name = name;
            this.publicKey = UUID.randomUUID().toString();
            this.privateKey = UUID.randomUUID().toString();
        }

        boolean authenticate(String key) {
            return privateKey.equals(key);
        }

        public String toString() {
            return name + " -> " + publicKey.substring(0, 8);
        }
    }

    public static void main(String[] args) {
        KeyPair key = new KeyPair("ec2-access");

        System.out.println(key);

        String attempt = key.privateKey;
        System.out.println("Auth Success: " + key.authenticate(attempt));

        System.out.println("Auth Failure: " + key.authenticate("invalid-key"));
    }
}