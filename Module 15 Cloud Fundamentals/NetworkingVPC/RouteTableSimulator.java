import java.util.*;

public class RouteTableSimulator {
    static class Route {
        String destination;
        String target;

        Route(String destination, String target) {
            this.destination = destination;
            this.target = target;
        }
    }

    public static void main(String[] args) {
        Map<String, String> routeTable = new HashMap<>();

        routeTable.put("0.0.0.0/0", "igw-1");
        routeTable.put("10.0.0.0/16", "local");

        String lookup = "0.0.0.0/0";
        System.out.println("Route -> " + routeTable.get(lookup));
    }
}