class Account {
    String holder;
    int balance;
}

class AccountView {
    void show(String h, int b) {
        System.out.println(h);
        System.out.println("Balance = " + b);
    }
}

public class Main {
    public static void main(String[] args) {

        Account model = new Account();
        model.holder = "Vinni";
        model.balance = 5000;

        AccountView view = new AccountView();

        view.show(model.holder, model.balance);
    }
}