import java.util.*;

public class ECSClusterSimulator {
    static class Node {
        String name;
        int capacity;
        int used;

        Node(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        boolean assignTask() {
            if (used < capacity) {
                used++;
                return true;
            }
            return false;
        }

        public String toString() {
            return name + " " + used + "/" + capacity;
        }
    }

    public static void main(String[] args) {
        List<Node> cluster = new ArrayList<>();
        cluster.add(new Node("node-1", 2));
        cluster.add(new Node("node-2", 3));

        for (int i = 1; i <= 4; i++) {
            for (Node n : cluster) {
                if (n.assignTask()) break;
            }
        }

        cluster.forEach(System.out::println);
    }
}