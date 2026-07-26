import java.util.*;

public class QueryEngine {
    static class Record {
        int id;
        String name;

        Record(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Record> records = List.of(
                new Record(1, "alpha"),
                new Record(2, "beta"),
                new Record(3, "alpha")
        );

        String filter = "alpha";

        records.stream()
               .filter(r -> r.name.equals(filter))
               .map(r -> r.id)
               .forEach(System.out::println);
    }
}