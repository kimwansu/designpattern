package ch22.command;

import java.util.Stack;
import java.util.Iterator;

public class MacroCommand implements Command
{
    private Stack<Command> commands = new Stack<Command>();
    
    @Override
    public void execute()
    {
        Iterator<Command> it = this.commands.iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }
    
    public void append(Command cmd)
    {
        if (cmd != this) {
            this.commands.push(cmd);
        }
    }
    
    public void undo()
    {
        if (!this.commands.empty()) {
            this.commands.pop();
        }
    }
    
    public void clear()
    {
        this.commands.clear();
    }
}
