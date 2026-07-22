import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AppTest {

    public static void main(String[] args) throws Exception {
        test("/");
        test("/health");
    }

    private static void test(String path) throws Exception {
        URL url = new URL("http://localhost:5000" + path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int code = con.getResponseCode();
        Scanner sc = new Scanner(con.getInputStream());
        StringBuilder res = new StringBuilder();

        while (sc.hasNext()) res.append(sc.nextLine());

        if (code != 200) throw new RuntimeException("Failed " + path);
        if (!res.toString().contains("status")) throw new RuntimeException("Invalid response");

        sc.close();
    }
}