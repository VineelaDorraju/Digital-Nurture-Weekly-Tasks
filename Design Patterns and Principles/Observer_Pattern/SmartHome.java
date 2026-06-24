interface Device{
    void update();
}

class Mobile implements Device{
    public void update(){
        System.out.println("Door Opened");
    }
}

public class Main{
    public static void main(String[] args){

        Device d = new Mobile();
        d.update();
    }
}