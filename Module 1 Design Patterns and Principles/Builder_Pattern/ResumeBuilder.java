class Resume {
    String name, skill;

    static class Builder {
        Resume r = new Resume();

        Builder setName(String n) { r.name = n; return this; }
        Builder setSkill(String s) { r.skill = s; return this; }

        Resume build() { return r; }
    }
}

public class Builder1_Classic {
    public static void main(String[] args) {
        Resume r = new Resume.Builder()
                .setName("Vineela")
                .setSkill("Java")
                .build();

        System.out.println(r.name + " " + r.skill);
    }
}