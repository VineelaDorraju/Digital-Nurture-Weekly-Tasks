interface Payment {
    void pay(int amount);
}

class OldPaymentSystem {
    void makePayment(int amt) {
        System.out.println("Paid using old system: " + amt);
    }
}

class PaymentAdapter implements Payment {
    OldPaymentSystem old = new OldPaymentSystem();

    public void pay(int amount) {
        old.makePayment(amount);
    }
}

public class AdapterExample2_Payment {
    public static void main(String[] args) {
        Payment p = new PaymentAdapter();
        p.pay(500);
    }
}