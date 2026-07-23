import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name = "students")
class Student {

    @Id
    private int id;

    @Column(name = "student_name")
    private String name;

    private String course;

    public Student() {}

    // parameterized constructor
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    // display method
    public void show() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}

public class EntityExample {
    public static void main(String[] args) {
        Student s = new Student(101, "Vineela", "Spring ORM");

        System.out.println("Student Data:");
        s.show();
    }
}