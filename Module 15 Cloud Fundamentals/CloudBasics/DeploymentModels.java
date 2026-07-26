import java.util.*;

public class DeploymentModels {
    enum Model {
        PUBLIC, PRIVATE, HYBRID, COMMUNITY
    }

    static class Scenario {
        String need;
        boolean highSecurity;
        boolean costSensitive;

        Scenario(String need, boolean highSecurity, boolean costSensitive) {
            this.need = need;
            this.highSecurity = highSecurity;
            this.costSensitive = costSensitive;
        }
    }

    public static void main(String[] args) {
        List<Scenario> cases = List.of(
                new Scenario("startup app", false, true),
                new Scenario("banking system", true, false),
                new Scenario("enterprise scaling", true, true)
        );

        cases.stream()
                .map(DeploymentModels::decide)
                .forEach(System.out::println);
    }

    static Model decide(Scenario s) {
        if (s.highSecurity && s.costSensitive) return Model.HYBRID;
        if (s.highSecurity) return Model.PRIVATE;
        if (s.costSensitive) return Model.PUBLIC;
        return Model.COMMUNITY;
    }
}