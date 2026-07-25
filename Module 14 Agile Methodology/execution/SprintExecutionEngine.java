import java.util.*;

class SprintExecutionEngine {

    static class Task {
        String name;
        int remaining;

        Task(String n, int r) {
            name = n;
            remaining = r;
        }
    }

    public static void main(String[] args) {
        List<Task> sprint = new ArrayList<>();

        sprint.add(new Task("Login API", 3));
        sprint.add(new Task("Dashboard UI", 4));
        sprint.add(new Task("Notification Service", 2));

        int day = 1;

        while (!sprint.isEmpty()) {
            System.out.println("Day " + day);

            Iterator<Task> it = sprint.iterator();
            while (it.hasNext()) {
                Task t = it.next();
                t.remaining--;

                System.out.println(t.name + " -> remaining " + t.remaining);

                if (t.remaining == 0) {
                    System.out.println(t.name + " completed");
                    it.remove();
                }
            }

            day++;
            System.out.println();
        }

        System.out.println("Sprint Completed in " + (day - 1) + " days");
    }
}