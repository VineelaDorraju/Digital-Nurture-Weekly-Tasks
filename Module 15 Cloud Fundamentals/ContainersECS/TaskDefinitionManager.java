import java.util.*;

public class TaskDefinitionManager {
    static class TaskDefinition {
        String name;
        int cpu;
        int memory;
        List<String> containers = new ArrayList<>();

        TaskDefinition(String name, int cpu, int memory) {
            this.name = name;
            this.cpu = cpu;
            this.memory = memory;
        }

        void addContainer(String container) {
            containers.add(container);
        }

        public String toString() {
            return name + " | CPU:" + cpu + " | MEM:" + memory + " | " + containers;
        }
    }

    public static void main(String[] args) {
        TaskDefinition task = new TaskDefinition("payment-task", 512, 1024);
        task.addContainer("payment-api");
        task.addContainer("logger");

        TaskDefinition task2 = new TaskDefinition("user-task", 256, 512);
        task2.addContainer("user-service");

        List<TaskDefinition> tasks = List.of(task, task2);

        tasks.stream()
             .sorted(Comparator.comparingInt(t -> -t.cpu))
             .forEach(System.out::println);
    }
}