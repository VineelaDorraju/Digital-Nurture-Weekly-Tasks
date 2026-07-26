import java.util.*;

public class S3LifecyclePolicy {
    static class ObjectEntry {
        String name;
        int age;

        ObjectEntry(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<ObjectEntry> objects = new ArrayList<>();
        objects.add(new ObjectEntry("backup.zip", 45));
        objects.add(new ObjectEntry("temp.log", 10));

        int threshold = 30;

        objects.removeIf(obj -> obj.age > threshold);

        objects.forEach(o -> System.out.println(o.name));
    }
}