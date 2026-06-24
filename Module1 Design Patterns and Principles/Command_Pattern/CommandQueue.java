import java.util.*;

interface Command {
    void execute();
}

class PrintCommand implements Command {
    String msg;

    PrintCommand(String msg) {
        this.msg = msg;
    }

    public void execute() {
        System.out.println(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<Command> q = new LinkedList<>();

        q.add(new PrintCommand("Task 1"));
        q.add(new PrintCommand("Task 2"));

        while (!q.isEmpty()) {
            q.poll().execute();
        }
    }
}