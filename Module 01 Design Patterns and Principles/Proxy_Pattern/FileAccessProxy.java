interface File{
    void open();
}

class RealFile implements File{
    public void open(){
        System.out.println("File Opened");
    }
}

class FileProxy implements File{
    public void open(){
        System.out.println("Permission Checked");
        new RealFile().open();
    }
}

public class Main{
    public static void main(String[] args){

        File f = new FileProxy();
        f.open();

    }
}