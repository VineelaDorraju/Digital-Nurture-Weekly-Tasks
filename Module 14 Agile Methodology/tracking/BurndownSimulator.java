import java.util.*;

class BurndownSimulator {

    public static void main(String[] args) {
        int totalPoints = 30;
        int days = 6;

        List<Integer> dailyCompletion = Arrays.asList(5, 4, 6, 5, 7, 3);

        int remaining = totalPoints;

        System.out.println("Day | Remaining Work");

        for (int i = 0; i < days; i++) {
            remaining -= dailyCompletion.get(i);
            if (remaining < 0) remaining = 0;

            System.out.println((i + 1) + "   | " + remaining);
        }

        if (remaining == 0) {
            System.out.println("Sprint completed successfully");
        } else {
            System.out.println("Work spilled over: " + remaining);
        }
    }
}