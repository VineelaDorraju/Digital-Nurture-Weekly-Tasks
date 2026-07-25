import java.util.*;

class IncrementDeliverySystem {

    static class Feature {
        String name;
        boolean tested;
        boolean integrated;

        Feature(String n, boolean t, boolean i) {
            name = n;
            tested = t;
            integrated = i;
        }

        boolean isDeliverable() {
            return tested && integrated;
        }
    }

    public static void main(String[] args) {
        List<Feature> increment = Arrays.asList(
            new Feature("Login", true, true),
            new Feature("Search", true, false),
            new Feature("Checkout", true, true)
        );

        System.out.println("Deliverable Increment:");

        for (Feature f : increment) {
            if (f.isDeliverable()) {
                System.out.println(f.name + " delivered");
            } else {
                System.out.println(f.name + " blocked");
            }
        }
    }
}