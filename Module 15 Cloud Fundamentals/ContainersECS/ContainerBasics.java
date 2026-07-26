import java.util.*;

public class ContainerBasics {
    static class Container {
        String name;
        String image;
        boolean running;

        Container(String name, String image) {
            this.name = name;
            this.image = image;
        }

        void run() { running = true; }
        void stop() { running = false; }

        public String toString() {
            return name + " (" + image + ") : " + (running ? "active" : "idle");
        }
    }

    public static void main(String[] args) {
        List<Container> list = List.of(
                new Container("auth-service", "node:18"),
                new Container("db-service", "mysql:8")
        );

        list.forEach(Container::run);
        list.forEach(System.out::println);
    }
}