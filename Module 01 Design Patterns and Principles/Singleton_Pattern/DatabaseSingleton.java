class Database{

    static Database db = new Database();

    private Database(){}

    static Database getInstance(){
        return db;
    }
}

public class Main{
    public static void main(String[] args){

        Database d1 = Database.getInstance();
        Database d2 = Database.getInstance();

        System.out.println(d1 == d2);
    }
}