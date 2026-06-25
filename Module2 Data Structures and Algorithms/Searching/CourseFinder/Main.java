public class Main {

    public static void main(String[] args) {

        Course[] courses = {

                new Course(101, "Java Programming"),
                new Course(102, "Data Structures"),
                new Course(103, "DBMS"),
                new Course(104, "Operating Systems"),
                new Course(105, "Machine Learning"),
                new Course(106, "Cloud Computing"),
                new Course(107, "Cyber Security")
        };

        CourseDatabase database = new CourseDatabase(courses);

        SearchEngine engine = new SearchEngine(database);

        int targetId = 105;

        int left = 0;
        int right = engine.database.courses.length - 1;

        boolean found = false;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (engine.database.courses[mid].id == targetId) {

                System.out.println("Course Found");
                System.out.println("ID : " +engine.database.courses[mid].id);

                System.out.println("Course : " +engine.database.courses[mid].name);

                found = true;
                break;
            }

            if (targetId > engine.database.courses[mid].id) {

                left = mid + 1;
            } else {

                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Course Not Found");
        }
    }
}