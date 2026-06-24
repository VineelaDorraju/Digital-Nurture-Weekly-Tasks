import java.util.*;

interface Investor {
    void update(int price);
}

class Trader implements Investor {
    public void update(int price) {
        System.out.println("Stock Price: " + price);
    }
}

class Stock {
    List<Investor> investors = new ArrayList<>();
}

public class Main {
    public static void main(String[] args) {

        Stock stock = new Stock();

        Trader t1 = new Trader();

        stock.investors.add(t1);

        for(Investor i : stock.investors) {
            i.update(2500);
        }
    }
}