import java.util.*;

public class CloudVsOnPremise {
    static class Option {
        String name;
        int scalability;
        int cost;
        int maintenance;

        Option(String name, int scalability, int cost, int maintenance) {
            this.name = name;
            this.scalability = scalability;
            this.cost = cost;
            this.maintenance = maintenance;
        }

        int score() {
            return scalability * 3 - cost * 2 - maintenance;
        }
    }

    public static void main(String[] args) {
        Option cloud = new Option("Cloud", 9, 6, 2);
        Option onPrem = new Option("OnPremise", 5, 8, 7);

        List<Option> list = List.of(cloud, onPrem);

        list.stream()
            .sorted((a, b) -> b.score() - a.score())
            .forEach(o -> System.out.println(o.name + " Score: " + o.score()));

        System.out.println("\nRecommended: " + list.stream()
                .max(Comparator.comparingInt(Option::score))
                .get().name);
    }
}