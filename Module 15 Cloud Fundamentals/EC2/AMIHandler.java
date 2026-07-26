import java.util.*;

public class AMIHandler {
    static class AMI {
        String id;
        String os;
        boolean active;

        AMI(String id, String os) {
            this.id = id;
            this.os = os;
            this.active = true;
        }

        void deactivate() {
            active = false;
        }

        public String toString() {
            return id + " : " + os + " : " + (active ? "available" : "disabled");
        }
    }

    public static void main(String[] args) {
        List<AMI> images = new ArrayList<>();
        images.add(new AMI("ami-01", "Linux"));
        images.add(new AMI("ami-02", "Windows"));

        images.stream()
              .filter(a -> a.os.equals("Linux"))
              .findFirst()
              .ifPresent(AMI::deactivate);

        images.forEach(System.out::println);
    }
}