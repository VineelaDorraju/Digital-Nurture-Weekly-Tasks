import java.util.*;

public class S3BucketManager {
    static class Bucket {
        String name;
        Set<String> objects = new HashSet<>();

        Bucket(String name) {
            this.name = name;
        }

        void upload(String file) {
            objects.add(file);
        }

        void delete(String file) {
            objects.remove(file);
        }

        public String toString() {
            return name + " -> " + objects;
        }
    }

    public static void main(String[] args) {
        Bucket bucket = new Bucket("app-data");
        bucket.upload("image.png");
        bucket.upload("log.txt");
        bucket.delete("log.txt");

        System.out.println(bucket);
    }
}