import java.util.*;

class SprintReportGenerator {

    public static void main(String[] args) {
        List<Integer> committed = Arrays.asList(20, 25, 30);
        List<Integer> completed = Arrays.asList(18, 22, 28);

        System.out.println("Sprint Report:");

        for (int i = 0; i < committed.size(); i++) {
            int c = committed.get(i);
            int d = completed.get(i);

            double efficiency = (d * 100.0) / c;

            System.out.println("Sprint " + (i + 1) +
                " | Committed: " + c +
                " | Done: " + d +
                " | Efficiency: " + (int)efficiency + "%");
        }
    }
}