class Student {
    private String name;
    private Course course;

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void display() {
        System.out.println("Student: " + name);
        System.out.println("Course: " + course.getCourseName());
    }
}