package ch23;

public class PrimitiveCommandNode extends Node
{
    private String name;
    
    public void parse(Context context) throws ParseException
    {
        this.name = context.currentToken();
        context.skipToken(this.name);
        if (!this.name.equals("go") && !this.name.equals("right") && !this.name.equals("left")) {
            throw new ParseException(this.name + " is undefined");
        }
    }
    
    public String toString()
    {
        return this.name;
    }
}
