import java.util.*;

interface Command {
    void execute();
}

class MacroCommand implements Command {
    List<Command> commands;

    MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    public void execute() {
        for (Command c : commands) {
            c.execute();
        }
    }
}