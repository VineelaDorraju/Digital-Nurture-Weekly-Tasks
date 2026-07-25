import java.util.*;

class RoleInteractionSimulator {

    static class ProductOwner {
        Queue<String> backlog = new LinkedList<>();

        void addStory(String story) {
            backlog.add(story);
        }

        String refineStory() {
            return backlog.poll();
        }
    }

    static class ScrumMaster {
        void facilitate(String event) {
            System.out.println("ScrumMaster facilitating " + event);
        }
    }

    static class DevTeam {
        List<String> sprintTasks = new ArrayList<>();

        void pickTask(String task) {
            sprintTasks.add(task);
            System.out.println("DevTeam picked: " + task);
        }

        void completeTasks() {
            for (String t : sprintTasks) {
                System.out.println("Completed: " + t);
            }
        }
    }

    public static void main(String[] args) {
        ProductOwner po = new ProductOwner();
        ScrumMaster sm = new ScrumMaster();
        DevTeam team = new DevTeam();

        po.addStory("User Authentication");
        po.addStory("Cart System");

        sm.facilitate("Sprint Planning");

        String story;
        while ((story = po.refineStory()) != null) {
            team.pickTask(story);
        }

        sm.facilitate("Daily Scrum");
        sm.facilitate("Sprint Review");

        team.completeTasks();

        sm.facilitate("Sprint Retrospective");
    }
}