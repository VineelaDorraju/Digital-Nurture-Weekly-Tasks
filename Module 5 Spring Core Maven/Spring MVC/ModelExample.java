class ModelEx {

    private String message;
    private String user;

    public ModelEx(String user) {
        this.user = user;
        this.message = "Welcome to Spring MVC";
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }

    public void display() {
        System.out.println("User: " + user);
        System.out.println("Message: " + message);
    }
}