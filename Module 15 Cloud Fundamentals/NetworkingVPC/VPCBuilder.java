import java.util.*;

public class VPCBuilder {
    static class VPC {
        String cidr;
        List<String> subnets = new ArrayList<>();

        VPC(String cidr) {
            this.cidr = cidr;
        }

        void addSubnet(String subnet) {
            subnets.add(subnet);
        }

        public String toString() {
            return "VPC " + cidr + " " + subnets;
        }
    }

    public static void main(String[] args) {
        VPC vpc = new VPC("10.0.0.0/16");
        vpc.addSubnet("10.0.1.0/24");
        vpc.addSubnet("10.0.2.0/24");

        System.out.println(vpc);
    }
}