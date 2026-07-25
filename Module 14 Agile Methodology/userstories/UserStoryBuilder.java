import java.util.*;

class UserStoryBuilder {

    static class UserStory {
        String user;
        String goal;
        String benefit;

        UserStory(String u, String g, String b) {
            user = u;
            goal = g;
            benefit = b;
        }

        String build() {
            return "As a " + user + ", I want " + goal + ", so that " + benefit;
        }

        boolean isValid() {
            return user.length() > 0 && goal.length() > 0 && benefit.length() > 0;
        }
    }

    public static void main(String[] args) {
        UserStory story = new UserStory(
            "customer",
            "track my orders",
            "I can know delivery status in real time"
        );

        if (story.isValid()) {
            System.out.println(story.build());
        } else {
            System.out.println("Invalid User Story");
        }
    }
}