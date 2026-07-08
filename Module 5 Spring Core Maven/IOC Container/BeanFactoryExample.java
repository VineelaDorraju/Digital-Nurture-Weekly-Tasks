import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class BeanFactoryExample {

    // ----- Course class -----
    static class Course {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // ----- Student class -----
    static class Student {
        private String studentName;
        private Course course;

        // setter injection
        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public void display() {
            System.out.println("Student: " + studentName);
            System.out.println("Course: " + course.getName());
        }
    }

    public static void main(String[] args) {
        String xml =
                "<beans>" +
                "   <bean id='course' class='BeanFactoryExample$Course'>" +
                "       <property name='name' value='Spring Core'/>" +
                "   </bean>" +
                "   <bean id='student' class='BeanFactoryExample$Student'>" +
                "       <property name='studentName' value='Vineela'/>" +
                "       <property name='course' ref='course'/>" +
                "   </bean>" +
                "</beans>";

        Resource resource = new ByteArrayResource(xml.getBytes());
        BeanFactory factory = new XmlBeanFactory(resource);
        Student s = (Student) factory.getBean("student");
        s.display();
    }
}