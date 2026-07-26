import java.util.*;

public class SnapshotHandler {
    static class Snapshot {
        String id;
        String volumeId;
        long timestamp;

        Snapshot(String id, String volumeId) {
            this.id = id;
            this.volumeId = volumeId;
            this.timestamp = System.currentTimeMillis();
        }

        public String toString() {
            return id + " from " + volumeId;
        }
    }

    public static void main(String[] args) {
        List<Snapshot> snaps = new ArrayList<>();

        snaps.add(new Snapshot("snap-1", "vol-1"));
        snaps.add(new Snapshot("snap-2", "vol-2"));

        snaps.stream()
             .sorted(Comparator.comparingLong(s -> -s.timestamp))
             .forEach(System.out::println);
    }
}