class Singer {
    String era;
}

class EraView {
    void display(String era) {
        System.out.println("Current Era: " + era);
    }
}

public class Main {
    public static void main(String[] args) {

        Singer model = new Singer();
        model.era = "Reputation";

        EraView view = new EraView();

        view.display(model.era);
    }
}