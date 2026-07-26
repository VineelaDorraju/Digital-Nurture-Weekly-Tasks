import java.util.*;

public class ALBSimulator {
    static class Target {
        String name;
        int requests;

        Target(String name) {
            this.name = name;
        }

        void handle() {
            requests++;
        }

        public String toString() {
            return name + " -> " + requests;
        }
    }

    public static void main(String[] args) {
        List<Target> targets = List.of(
                new Target("app-1"),
                new Target("app-2")
        );

        int i = 0;
        for (int r = 0; r < 6; r++) {
            targets.get(i).handle();
            i = (i + 1) % targets.size();
        }

        targets.forEach(System.out::println);
    }
}