import java.util.*;

class TaskFlowManager {

    static class Task {
        String name;

        Task(String n) {
            name = n;
        }
    }

    public static void main(String[] args) {
        Queue<Task> todo = new LinkedList<>();
        Queue<Task> inProgress = new LinkedList<>();
        Queue<Task> done = new LinkedList<>();

        todo.add(new Task("Auth Module"));
        todo.add(new Task("Search Feature"));
        todo.add(new Task("Payment Gateway"));

        int cycle = 1;

        while (!todo.isEmpty() || !inProgress.isEmpty()) {
            System.out.println("Cycle " + cycle);

            if (!todo.isEmpty()) {
                Task t = todo.poll();
                inProgress.add(t);
                System.out.println(t.name + " moved to InProgress");
            }

            if (!inProgress.isEmpty()) {
                Task t = inProgress.poll();
                done.add(t);
                System.out.println(t.name + " moved to Done");
            }

            cycle++;
            System.out.println();
        }

        System.out.println("All tasks completed: " + done.size());
    }
}