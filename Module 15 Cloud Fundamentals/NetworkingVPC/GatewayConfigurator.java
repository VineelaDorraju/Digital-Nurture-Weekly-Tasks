import java.util.*;

public class GatewayConfigurator {
    static class Gateway {
        String id;
        String type;

        Gateway(String id, String type) {
            this.id = id;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        List<Gateway> gateways = new ArrayList<>();

        gateways.add(new Gateway("igw-1", "internet"));
        gateways.add(new Gateway("nat-1", "nat"));

        gateways.stream()
                .map(g -> g.type + ":" + g.id)
                .forEach(System.out::println);
    }
}