class PaymentService {
    void pay() {
        System.out.println("Payment done via UPI");
    }
}

class OrderService {
    private PaymentService payment;
    OrderService(PaymentService payment) {
        this.payment = payment;
    }

    void placeOrder() {
        System.out.println("Order placed successfully");
        payment.pay();
    }
}
public class Main {
    public static void main(String[] args) {
        PaymentService p = new PaymentService();
        OrderService o = new OrderService(p);
        o.placeOrder();
    }
}