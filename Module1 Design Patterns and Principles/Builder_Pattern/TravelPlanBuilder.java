class TravelPlan {
    String destination, hotel;
    boolean guide;

    static class Builder {
        TravelPlan t = new TravelPlan();

        Builder destination(String d) { t.destination = d; return this; }
        Builder hotel(String h) { t.hotel = h; return this; }
        Builder guide(boolean g) { t.guide = g; return this; }

        TravelPlan build() { return t; }
    }

    void show() {
        System.out.println(destination + " | " + hotel + " | Guide: " + guide);
    }
}

public class BuilderExample6_TravelPlan {
    public static void main(String[] args) {
        TravelPlan plan = new TravelPlan.Builder()
                .destination("Goa")
                .hotel("Beach Resort")
                .guide(true)
                .build();

        plan.show();
    }
}