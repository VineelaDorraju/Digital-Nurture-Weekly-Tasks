class Charger {
    void charge() {
        System.out.println("Phone Charging");
    }
}

class Mobile {
    Charger charger;

    Mobile(Charger charger) {
        this.charger = charger;
    }

    void powerOn() {
        charger.charge();
    }
}

public class Main {
    public static void main(String[] args) {
        Mobile phone = new Mobile(new Charger());
        phone.powerOn();
    }
}