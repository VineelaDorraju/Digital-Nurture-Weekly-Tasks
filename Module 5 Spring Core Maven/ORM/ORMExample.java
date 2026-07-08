import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "students")
class Student {

    @Id
    private int id;
    private String name;
    private String course;

    public Student() {}

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}

public class ORMExample {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Vineela", "Spring ORM");

        System.out.println("Student Record:");
        s1.display();
    }
}