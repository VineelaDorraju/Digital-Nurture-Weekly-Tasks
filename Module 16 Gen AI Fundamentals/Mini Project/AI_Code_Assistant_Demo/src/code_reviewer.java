public class CodeReviewer {

    public String review(String code) {
        if (code == null || code.trim().isEmpty()) {
            return "Review failed: No source code provided.";
        }

        if (code.contains("System.out.println")) {
            return "Review completed: Code is readable. Consider using a logging framework for production applications.";
        }

        return "Review completed: No major issues detected.";
    }
}