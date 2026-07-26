import java.util.*;

public class EBSVolumeManager {
    static class Volume {
        String id;
        int size;
        boolean attached;

        Volume(String id, int size) {
            this.id = id;
            this.size = size;
        }

        void attach() { attached = true; }
        void detach() { attached = false; }

        public String toString() {
            return id + " " + size + "GB " + (attached ? "attached" : "detached");
        }
    }

    public static void main(String[] args) {
        Volume v1 = new Volume("vol-1", 100);
        Volume v2 = new Volume("vol-2", 200);

        v1.attach();

        List<Volume> vols = Arrays.asList(v1, v2);
        vols.forEach(System.out::println);
    }
}