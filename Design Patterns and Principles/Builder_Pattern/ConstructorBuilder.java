class User {
    String name;
    int age;

    static class Builder {
        String name;
        int age;

        Builder(String name) { this.name = name; }

        Builder age(int age) {
            this.age = age;
            return this;
        }

        User build() {
            return new User(this);
        }
    }

    private User(Builder b) {
        this.name = b.name;
        this.age = b.age;
    }
}

public class Builder3_Constructor {
    public static void main(String[] args) {
        User u = new User.Builder("Vineela")
                .age(20)
                .build();

        System.out.println(u.name + " " + u.age);
    }
}