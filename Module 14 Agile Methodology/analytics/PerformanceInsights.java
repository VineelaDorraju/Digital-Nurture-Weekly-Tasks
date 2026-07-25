import java.util.*;

class PerformanceInsights {

    static String trend(List<Integer> velocity) {
        int up = 0, down = 0;

        for (int i = 1; i < velocity.size(); i++) {
            if (velocity.get(i) > velocity.get(i - 1)) up++;
            else down++;
        }

        if (up > down) return "Improving";
        if (down > up) return "Declining";
        return "Stable";
    }

    public static void main(String[] args) {
        List<Integer> velocity = Arrays.asList(20, 22, 25, 23, 27);

        System.out.println("Velocity History: " + velocity);
        System.out.println("Performance Trend: " + trend(velocity));
    }
}