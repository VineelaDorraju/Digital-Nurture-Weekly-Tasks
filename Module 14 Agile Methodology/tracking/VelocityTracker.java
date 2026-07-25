import java.util.*;

class VelocityTracker {

    static int calculateVelocity(List<Integer> completedPoints) {
        int sum = 0;
        for (int p : completedPoints) {
            sum += p;
        }
        return sum / completedPoints.size();
    }

    public static void main(String[] args) {
        List<Integer> sprintHistory = Arrays.asList(20, 25, 18, 30, 27);

        int velocity = calculateVelocity(sprintHistory);

        System.out.println("Sprint History: " + sprintHistory);
        System.out.println("Average Velocity: " + velocity);

        int nextSprintCapacity = velocity;
        System.out.println("Suggested Next Sprint Capacity: " + nextSprintCapacity);
    }
}