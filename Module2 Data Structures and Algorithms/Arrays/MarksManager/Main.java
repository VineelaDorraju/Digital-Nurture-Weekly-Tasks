public class Main {

    public static void main(String[] args) {

        Student[] students = {
                new Student("Rahul", 82),
                new Student("Priya", 95),
                new Student("Kiran", 78),
                new Student("Anjali", 89),
                new Student("Vikram", 91)
        };

        MarksManager manager = new MarksManager(students);

        System.out.println("STUDENT MARKS MANAGER");

        int total = 0;
        int highest = students[0].marks;
        String topper = students[0].name;

        for (int i = 0; i < manager.students.length; i++) {

            System.out.println(manager.students[i].name +" : " + manager.students[i].marks);

            total += manager.students[i].marks;

            if (manager.students[i].marks > highest) {
                highest = manager.students[i].marks;
                topper = manager.students[i].name;
            }
        }

        double average = (double) total / manager.students.length;

        System.out.println("\nTotal Marks : " + total);
        System.out.println("Average Marks : " + average);
        System.out.println("Topper : " + topper);
        System.out.println("Highest Marks : " + highest);
    }
}