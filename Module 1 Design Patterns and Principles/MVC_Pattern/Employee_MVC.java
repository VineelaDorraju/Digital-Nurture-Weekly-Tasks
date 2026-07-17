class Employee {
    String name;
    int salary;
}

class EmployeeView {
    void display(String name, int salary) {
        System.out.println(name);
        System.out.println("Salary: " + salary);
    }
}

class EmployeeController {
    Employee model;
    EmployeeView view;
}

public class Main {
    public static void main(String[] args) {

        Employee e = new Employee();
        e.name = "Ravi";
        e.salary = 45000;

        EmployeeView view = new EmployeeView();

        EmployeeController c = new EmployeeController();
        c.model = e;
        c.view = view;

        c.view.display(c.model.name, c.model.salary);
    }
}