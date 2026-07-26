import java.util.*;

public class ServiceModels {
    private static final Map<String, List<String>> models = new LinkedHashMap<>();

    static {
        models.put("IaaS", List.of("EC2", "EBS", "VPC"));
        models.put("PaaS", List.of("Elastic Beanstalk", "App Runner"));
        models.put("SaaS", List.of("Gmail", "Dropbox"));
    }

    public static void main(String[] args) {
        models.forEach((k, v) -> {
            String joined = String.join(" | ", v);
            System.out.println(k + " => " + joined);
        });

        System.out.println("\nBest fit for startup: " + recommend("startup"));
        System.out.println("Best fit for enterprise: " + recommend("enterprise"));
    }

    static String recommend(String type) {
        return switch (type.toLowerCase()) {
            case "startup" -> "PaaS";
            case "enterprise" -> "IaaS";
            default -> "SaaS";
        };
    }
}