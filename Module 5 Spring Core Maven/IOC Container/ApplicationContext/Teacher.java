class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Teacher {

    private Subject subject;

    public Teacher(Subject subject) {
        this.subject = subject;
    }
    public void teach() {
        System.out.println("Teaching subject: " + subject.getName());
    }
}