class Rocket {
    void launch() {
        System.out.println("Rocket launched!");
    }
}

class SpaceMission {
    Rocket rocket;

    SpaceMission(Rocket rocket) {
        this.rocket = rocket;
    }

    void startMission() {
        rocket.launch();
    }
}

public class Main {
    public static void main(String[] args) {
        Rocket rocket = new Rocket();
        SpaceMission mission = new SpaceMission(rocket);
        mission.startMission();
    }
}