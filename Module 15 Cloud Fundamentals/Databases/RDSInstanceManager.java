import java.util.*;

public class RDSInstanceManager {
    static class RDS {
        String id;
        String engine;
        boolean running;

        RDS(String id, String engine) {
            this.id = id;
            this.engine = engine;
        }

        void start() { running = true; }
        void stop() { running = false; }

        public String toString() {
            return id + " (" + engine + ") " + (running ? "online" : "offline");
        }
    }

    public static void main(String[] args) {
        RDS db = new RDS("db-1", "MySQL");
        db.start();
        System.out.println(db);
    }
}