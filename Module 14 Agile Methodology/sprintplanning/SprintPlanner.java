import java.util.*;

class SprintPlanner {

    static class Story {
        String name;
        int points;

        Story(String n, int p) {
            name = n;
            points = p;
        }
    }

    public static void main(String[] args) {
        List<Story> backlog = Arrays.asList(
            new Story("Login", 5),
            new Story("Dashboard", 8),
            new Story("Notifications", 3),
            new Story("Profile", 5)
        );

        int sprintCapacity = 13;
        List<Story> sprint = new ArrayList<>();
        int used = 0;

        for (Story s : backlog) {
            if (used + s.points <= sprintCapacity) {
                sprint.add(s);
                used += s.points;
            }
        }

        System.out.println("Sprint Capacity: " + sprintCapacity);
        System.out.println("Selected Stories:");

        for (Story s : sprint) {
            System.out.println(s.name + " [" + s.points + "]");
        }
    }
}