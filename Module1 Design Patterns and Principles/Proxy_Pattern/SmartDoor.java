interface Door{
    void unlock();
}

class RealDoor implements Door{
    public void unlock(){
        System.out.println("Door Opened");
    }
}

class FingerprintProxy implements Door{
    public void unlock(){
        System.out.println("Fingerprint Matched");
        new RealDoor().unlock();
    }
}

public class Main{
    public static void main(String[] args){

        Door d = new FingerprintProxy();
        d.unlock();

    }
}