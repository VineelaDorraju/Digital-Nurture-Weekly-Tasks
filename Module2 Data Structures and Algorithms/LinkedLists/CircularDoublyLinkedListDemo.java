public class CircularDoublyLinkedListDemo {

    public static void main(String[] args) {

        class Node {
            String station;
            Node next, prev;

            Node(String station) {
                this.station = station;}}

        Node a = new Node("Ameerpet");
        Node b = new Node("Begumpet");
        Node c = new Node("Paradise");
        Node d = new Node("Secunderabad");
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = a;
        a.prev = d;
        System.out.println("Metro Route (Forward)");
        Node temp = a;
        do{
            System.out.println(temp.station);
            temp = temp.next;
        } while (temp != a);

        System.out.println("\nMetro Route (Backward)");
        temp = d;
        do {
            System.out.println(temp.station);
            temp = temp.prev;
        } while (temp != d);
    }
}