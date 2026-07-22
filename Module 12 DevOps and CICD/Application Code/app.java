import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class App {

    private static final long start = System.currentTimeMillis();

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);

        server.createContext("/", App::handleHome);
        server.createContext("/health", App::handleHealth);

        server.setExecutor(null);
        server.start();
    }

    private static void handleHome(HttpExchange exchange) {
        try {
            Map<String, Object> res = new HashMap<>();
            res.put("service", "DevOps Demo Service");
            res.put("status", "running");
            res.put("uptime", (System.currentTimeMillis() - start) / 1000.0);

            send(exchange, 200, toJson(res));
        } catch (Exception e) {
            send(exchange, 500, "{\"error\":\"internal\"}");
        }
    }

    private static void handleHealth(HttpExchange exchange) {
        try {
            Map<String, Object> res = new HashMap<>();
            res.put("status", "healthy");
            res.put("timestamp", Instant.now().toString());

            send(exchange, 200, toJson(res));
        } catch (Exception e) {
            send(exchange, 500, "{\"error\":\"internal\"}");
        }
    }

    private static void send(HttpExchange exchange, int code, String response) {
        try {
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(code, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (Exception ignored) {}
    }

    private static String toJson(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("{");
        for (String k : map.keySet()) {
            sb.append("\"").append(k).append("\":");
            Object v = map.get(k);
            if (v instanceof Number) sb.append(v);
            else sb.append("\"").append(v).append("\"");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}