import java.util.*;

public class SubnetManager {
    static class Subnet {
        String cidr;
        boolean isPublic;

        Subnet(String cidr, boolean isPublic) {
            this.cidr = cidr;
            this.isPublic = isPublic;
        }
    }

    public static void main(String[] args) {
        List<Subnet> subnets = List.of(
                new Subnet("10.0.1.0/24", true),
                new Subnet("10.0.2.0/24", false)
        );

        long publicCount = subnets.stream().filter(s -> s.isPublic).count();

        System.out.println("Public Subnets: " + publicCount);
    }
}