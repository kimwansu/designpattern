package ch23;

import java.util.ArrayList;

public class CommandListNode extends Node
{
    private ArrayList<Node> list = new ArrayList<Node>();
    
    public void parse(Context context) throws ParseException
    {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing end");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                this.list.add(commandNode);
            }
        }
    }
    
    public String toString()
    {
        return this.list.toString();
    }
}
