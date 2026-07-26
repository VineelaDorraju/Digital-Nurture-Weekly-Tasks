import java.util.*;

public class NLBSimulator {
    static class Node {
        String ip;

        Node(String ip) {
            this.ip = ip;
        }
    }

    public static void main(String[] args) {
        Queue<Node> pool = new LinkedList<>();

        pool.add(new Node("10.0.0.1"));
        pool.add(new Node("10.0.0.2"));

        for (int i = 0; i < 4; i++) {
            Node node = pool.poll();
            System.out.println("Forwarded to " + node.ip);
            pool.offer(node);
        }
    }
}