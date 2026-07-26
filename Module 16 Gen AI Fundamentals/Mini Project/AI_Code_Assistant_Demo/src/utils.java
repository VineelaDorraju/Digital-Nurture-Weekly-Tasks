public class Utils {

    public static String normalize(String text) {
        if (text == null) {
            return "";
        }
        return text.trim().replaceAll("\\s+", " ");
    }

    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }
}