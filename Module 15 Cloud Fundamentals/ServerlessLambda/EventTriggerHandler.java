import java.util.*;

public class EventTriggerHandler {
    static class Event {
        String type;

        Event(String type) {
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Queue<Event> queue = new LinkedList<>();
        queue.add(new Event("S3"));
        queue.add(new Event("API"));
        queue.add(new Event("DynamoDB"));

        while (!queue.isEmpty()) {
            Event e = queue.poll();
            System.out.println("Processing " + e.type);
        }
    }
}