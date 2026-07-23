interface Preparation {
    void prepare();
}

class SelfStudy implements Preparation {
    public void prepare() {
        System.out.println("Preparing by self study");
    }
}

class Coaching implements Preparation {
    public void prepare() {
        System.out.println("Preparing through coaching");
    }
}

public class ExamStrategy {
    public static void main(String[] args) {

        Preparation p = new SelfStudy();
        p.prepare();

        p = new Coaching();
        p.prepare();
    }
}