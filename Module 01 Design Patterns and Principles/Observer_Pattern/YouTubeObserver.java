interface Subscriber{
    void update();
}

class Viewer implements Subscriber{
    public void update(){
        System.out.println("New Video Uploaded");
    }
}

public class Main{
    public static void main(String[] args){

        Subscriber s = new Viewer();
        s.update();
    }
}