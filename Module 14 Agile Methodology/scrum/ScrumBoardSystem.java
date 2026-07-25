import java.util.*;

class ScrumBoardSystem {

    static class Card {
        String title;
        String status;

        Card(String t) {
            title = t;
            status = "ToDo";
        }
    }

    public static void main(String[] args) {
        List<Card> board = new ArrayList<>();

        board.add(new Card("Login Feature"));
        board.add(new Card("Search Module"));
        board.add(new Card("Payment Integration"));

        for (Card c : board) {
            move(c, "InProgress");
            move(c, "Review");
            move(c, "Done");
        }

        System.out.println("Final Board State:");
        for (Card c : board) {
            System.out.println(c.title + " -> " + c.status);
        }
    }

    static void move(Card c, String next) {
        c.status = next;
        System.out.println(c.title + " moved to " + next);
    }
}