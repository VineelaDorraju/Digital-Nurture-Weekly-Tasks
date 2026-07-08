import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Message {
    void show() {
        System.out.println("Maven + Spring setup successful");
    }
}

public class App {
    public static void main(String[] args) {

        // simple Spring container usage
        ApplicationContext context =
                new ClassPathXmlApplicationContext();

        Message m = new Message();
        m.show();
    }
}