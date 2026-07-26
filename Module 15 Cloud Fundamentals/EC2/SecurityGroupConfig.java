import java.util.*;

public class SecurityGroupConfig {
    static class Rule {
        int port;
        String source;

        Rule(int port, String source) {
            this.port = port;
            this.source = source;
        }

        public String toString() {
            return "Port " + port + " <- " + source;
        }
    }

    static class SecurityGroup {
        String name;
        List<Rule> inbound = new ArrayList<>();

        SecurityGroup(String name) {
            this.name = name;
        }

        void allow(int port, String source) {
            inbound.add(new Rule(port, source));
        }

        boolean isAllowed(int port) {
            return inbound.stream().anyMatch(r -> r.port == port);
        }

        public String toString() {
            return name + " " + inbound;
        }
    }

    public static void main(String[] args) {
        SecurityGroup sg = new SecurityGroup("web-sg");
        sg.allow(22, "0.0.0.0/0");
        sg.allow(80, "0.0.0.0/0");

        System.out.println(sg);
        System.out.println("Access 22: " + sg.isAllowed(22));
        System.out.println("Access 443: " + sg.isAllowed(443));
    }
}