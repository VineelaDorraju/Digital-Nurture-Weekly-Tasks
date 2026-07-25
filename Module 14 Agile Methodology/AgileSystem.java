import java.util.*;

class Story {
    String title;
    int points;
    boolean done;

    Story(String t, int p) {
        title = t;
        points = p;
        done = false;
    }

    void complete() {
        done = true;
    }
}

class Sprint {
    List<Story> backlog = new ArrayList<>();
    int totalPoints;

    void addStory(Story s) {
        backlog.add(s);
        totalPoints += s.points;
    }

    void startSprint() {
        System.out.println("Sprint Started with " + totalPoints + " points");
    }

    void execute() {
        for (Story s : backlog) {
            s.complete();
            System.out.println(s.title + " → Done");
        }
    }

    int completedPoints() {
        int sum = 0;
        for (Story s : backlog) {
            if (s.done) sum += s.points;
        }
        return sum;
    }
}

class PlanningPoker {
    static int estimate(int... votes) {
        int sum = 0;
        for (int v : votes) sum += v;
        return sum / votes.length;
    }
}

class AgileSystem {
    public static void main(String[] args) {

        Story s1 = new Story("Login Feature", PlanningPoker.estimate(3,5,5));
        Story s2 = new Story("Dashboard UI", PlanningPoker.estimate(5,8,5));
        Story s3 = new Story("Notifications", PlanningPoker.estimate(2,3,3));

        Sprint sprint = new Sprint();
        sprint.addStory(s1);
        sprint.addStory(s2);
        sprint.addStory(s3);

        sprint.startSprint();
        sprint.execute();

        int velocity = sprint.completedPoints();
        System.out.println("Sprint Velocity: " + velocity);

        int remaining = sprint.totalPoints;
        int days = 5;
        int burnPerDay = velocity / days;

        for (int i = 1; i <= days; i++) {
            remaining -= burnPerDay;
            if (remaining < 0) remaining = 0;
            System.out.println("Day " + i + " Remaining Work: " + remaining);
        }

        boolean done = velocity == sprint.totalPoints;
        System.out.println(done ? "Increment Delivered" : "Work Pending");
    }
}