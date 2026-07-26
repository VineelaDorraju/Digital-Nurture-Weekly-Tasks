import java.util.*;

public class MultiAZFailover {
    static class Instance {
        String zone;
        boolean active;

        Instance(String zone, boolean active) {
            this.zone = zone;
            this.active = active;
        }
    }

    public static void main(String[] args) {
        Instance primary = new Instance("az-1", true);
        Instance standby = new Instance("az-2", false);

        if (!primary.active) {
            standby.active = true;
        }

        System.out.println("Active zone: " + (primary.active ? primary.zone : standby.zone));
    }
}