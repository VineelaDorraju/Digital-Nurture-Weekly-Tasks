import java.util.*;

class DefinitionOfDoneValidator {

    static class Task {
        String name;
        boolean codeComplete;
        boolean testPassed;
        boolean reviewed;

        Task(String n, boolean c, boolean t, boolean r) {
            name = n;
            codeComplete = c;
            testPassed = t;
            reviewed = r;
        }

        boolean isDone() {
            return codeComplete && testPassed && reviewed;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
            new Task("Auth API", true, true, true),
            new Task("UI Fix", true, false, true),
            new Task("Payment", true, true, false)
        );

        for (Task t : tasks) {
            System.out.println(t.name + " -> " + (t.isDone() ? "Done" : "Not Done"));
        }
    }
}