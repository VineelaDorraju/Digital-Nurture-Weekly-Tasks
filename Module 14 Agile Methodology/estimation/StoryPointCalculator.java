import java.util.*;

class StoryPointCalculator {

    static int calculate(String complexity, String risk, String effort) {
        Map<String, Integer> scale = new HashMap<>();

        scale.put("low", 1);
        scale.put("medium", 3);
        scale.put("high", 5);

        int score = scale.get(complexity) + scale.get(risk) + scale.get(effort);

        if (score <= 3) return 2;
        if (score <= 6) return 5;
        if (score <= 9) return 8;
        return 13;
    }

    public static void main(String[] args) {
        String complexity = "medium";
        String risk = "high";
        String effort = "medium";

        int storyPoints = calculate(complexity, risk, effort);

        System.out.println("Complexity: " + complexity);
        System.out.println("Risk: " + risk);
        System.out.println("Effort: " + effort);
        System.out.println("Story Points: " + storyPoints);
    }
}