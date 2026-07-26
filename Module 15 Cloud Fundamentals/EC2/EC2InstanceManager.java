import java.util.*;

public class EC2InstanceManager {
    static class Instance {
        String id;
        String type;
        String state;

        Instance(String id, String type) {
            this.id = id;
            this.type = type;
            this.state = "stopped";
        }

        void start() { state = "running"; }
        void stop() { state = "stopped"; }

        public String toString() {
            return id + " [" + type + "] -> " + state;
        }
    }

    public static void main(String[] args) {
        List<Instance> instances = new ArrayList<>();
        instances.add(new Instance("i-101", "t2.micro"));
        instances.add(new Instance("i-102", "t2.small"));

        instances.forEach(Instance::start);

        instances.stream()
                .filter(i -> i.type.contains("micro"))
                .forEach(System.out::println);

        instances.get(1).stop();

        System.out.println("\nFinal State:");
        instances.forEach(System.out::println);
    }
}