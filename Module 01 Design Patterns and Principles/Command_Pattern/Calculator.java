interface Command {
    void execute();
}

class Calculator {
    int a = 10, b = 5;

    void add() {
        System.out.println(a + b);
    }
}

class AddCommand implements Command {
    Calculator calc;

    AddCommand(Calculator calc) {
        this.calc = calc;
    }

    public void execute() {
        calc.add();
    }
}