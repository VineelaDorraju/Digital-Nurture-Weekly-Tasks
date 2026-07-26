import java.util.*;

public class TrafficRouter {
    static class Service {
        String name;
        int weight;

        Service(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        List<Service> services = List.of(
                new Service("v1", 70),
                new Service("v2", 30)
        );

        int random = new Random().nextInt(100);
        int cumulative = 0;

        for (Service s : services) {
            cumulative += s.weight;
            if (random < cumulative) {
                System.out.println("Routed to " + s.name);
                break;
            }
        }
    }
}