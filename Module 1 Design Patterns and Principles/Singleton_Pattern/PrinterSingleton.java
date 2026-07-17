class Printer{

    static Printer obj = new Printer();

    private Printer(){}

    static Printer getInstance(){
        return obj;
    }
}

public class Main{
    public static void main(String[] args){

        Printer p1 = Printer.getInstance();
        Printer p2 = Printer.getInstance();

        System.out.println(p1 == p2);
    }
}