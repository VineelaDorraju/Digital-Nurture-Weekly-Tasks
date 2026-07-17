interface Question {
    void level();
}

class Easy implements Question {
    public void level() {
        System.out.println("Easy Question");
    }
}

class Hard implements Question {
    public void level() {
        System.out.println("Hard Question");
    }
}

class QuestionFactory {
    static Question create(int marks) {
        return marks > 10 ? new Hard() : new Easy();
    }
}

public class Main {
    public static void main(String[] args) {
        Question q = QuestionFactory.create(15);
        q.level();
    }
}