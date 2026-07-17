interface Command {
    void execute();
}

class TV {
    void on() {
        System.out.println("TV ON");
    }
}

class TVOnCommand implements Command {
    TV tv;

    TVOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.on();
    }
}