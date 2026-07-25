import java.util.*;

class AcceptanceCriteriaEngine {

    static class Scenario {
        String given;
        String when;
        String then;

        Scenario(String g, String w, String t) {
            given = g;
            when = w;
            then = t;
        }

        boolean validate() {
            return given.contains("user") && when.contains("action") && then.contains("result");
        }

        String describe() {
            return "Given " + given + "\nWhen " + when + "\nThen " + then;
        }
    }

    public static void main(String[] args) {
        Scenario s = new Scenario(
            "user is logged in",
            "user performs checkout action",
            "result shows successful payment"
        );

        System.out.println(s.describe());

        if (s.validate()) {
            System.out.println("Criteria Accepted");
        } else {
            System.out.println("Criteria Needs Refinement");
        }
    }
}