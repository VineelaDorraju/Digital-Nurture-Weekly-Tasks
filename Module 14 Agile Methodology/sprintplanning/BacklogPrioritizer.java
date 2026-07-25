import java.util.*;

class BacklogPrioritizer {

    static class Story {
        String name;
        int priority;
        int value;

        Story(String n, int p, int v) {
            name = n;
            priority = p;
            value = v;
        }
    }

    public static void main(String[] args) {
        List<Story> backlog = new ArrayList<>();

        backlog.add(new Story("Login", 1, 9));
        backlog.add(new Story("Search", 2, 7));
        backlog.add(new Story("Payment", 1, 10));
        backlog.add(new Story("Profile", 3, 6));

        backlog.sort((a, b) -> {
            if (a.priority != b.priority) return a.priority - b.priority;
            return b.value - a.value;
        });

        System.out.println("Prioritized Backlog:");

        for (Story s : backlog) {
            System.out.println(s.name + " P" + s.priority + " V" + s.value);
        }
    }
}