public class Main {

    public static void main(String[] args) {

        Building[] locations = {

                new Building("Control Room"),
                new Building("Research Lab"),
                new Building("Conference Hall"),
                new Building("Server Room"),
                new Building("Emergency Exit")
        };

        EvacuationMap evacuationMap =
                new EvacuationMap(locations);

        RoutePlanner planner =
                new RoutePlanner(evacuationMap);

        int[][] graph = {

                {0, 1, 1, 0, 0}, // Control Room
                {1, 0, 0, 1, 0}, // Research Lab
                {1, 0, 0, 0, 1}, // Conference Hall
                {0, 1, 0, 0, 1}, // Server Room
                {0, 0, 1, 1, 0}  // Emergency Exit
        };

        boolean[] visited = new boolean[5];

        int[] queue = new int[10];

        int front = 0;
        int rear = 0;

        queue[rear++] = 0;
        visited[0] = true;

        System.out.println("=== EMERGENCY EVACUATION ROUTE ===\n");

        while (front < rear) {

            int current = queue[front++];

            System.out.println(
                    "Checking: "
                    + planner.map.locations[current].name
            );

            if (planner.map.locations[current].name
                    .equals("Emergency Exit")) {

                System.out.println(
                        "\nSafe Exit Located!"
                );

                break;
            }

            for (int i = 0; i < graph.length; i++) {

                if (graph[current][i] == 1 &&
                        !visited[i]) {

                    visited[i] = true;

                    queue[rear++] = i;
                }
            }
        }
    }
}