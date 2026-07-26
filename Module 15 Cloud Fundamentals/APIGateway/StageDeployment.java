import java.util.*;

public class StageDeployment {
    static class Stage {
        String name;
        String version;

        Stage(String name, String version) {
            this.name = name;
            this.version = version;
        }
    }

    public static void main(String[] args) {
        List<Stage> stages = List.of(
                new Stage("dev", "v1"),
                new Stage("prod", "v2")
        );

        stages.stream()
              .filter(s -> s.name.equals("prod"))
              .findFirst()
              .ifPresent(s -> System.out.println(s.version));
    }
}