class Warden{
    static Warden w = new Warden();

    private Warden(){}

    static Warden getInstance(){
        return w;
    }
}

public class Main{
    public static void main(String[] args){

        Warden w1 = Warden.getInstance();
        Warden w2 = Warden.getInstance();

        System.out.println(w1 == w2);
    }
}