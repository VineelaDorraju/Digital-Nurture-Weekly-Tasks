interface Grade {
    void result();
}

class Pass implements Grade {
    public void result() {
        System.out.println("Student Passed");
    }
}

class Fail implements Grade {
    public void result() {
        System.out.println("Student Failed");
    }
}

class GradeFactory {
    static Grade check(int marks) {
        return marks >= 40 ? new Pass() : new Fail();
    }
}

public class Main {
    public static void main(String[] args) {
        Grade g = GradeFactory.check(65);
        g.result();
    }
}