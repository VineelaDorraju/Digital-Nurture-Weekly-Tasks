import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

@Component
class Car {

    @Autowired
    private Engine engine;

    void drive() {
        System.out.println("Car is moving...");
        engine.start();
    }
}

public class Main {
    public static void main(String[] args) {

        Engine e = new Engine();
        Car c = new Car();
        c = new Car();
        c.drive();
    }
}