interface Order {
    void place();
}

class Swiggy implements Order {
    public void place() {
        System.out.println("Order placed on Swiggy");
    }
}

class Zomato implements Order {
    public void place() {
        System.out.println("Order placed on Zomato");
    }
}

public class OrderStrategy {
    public static void main(String[] args) {

        Order o = new Swiggy();
        o.place();

        o = new Zomato();
        o.place();
    }
}