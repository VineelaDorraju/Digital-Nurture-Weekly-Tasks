interface Movie{
    void watch();
}

class RealMovie implements Movie{
    public void watch(){
        System.out.println("Movie Playing");
    }
}

class AgeProxy implements Movie{
    public void watch(){
        System.out.println("Age Verified");
        new RealMovie().watch();
    }
}

public class Main{
    public static void main(String[] args){

        Movie m = new AgeProxy();
        m.watch();

    }
}