package ch22.drawer;

import ch22.command.Command;
import java.awt.Point;

public class DrawCommand implements Command
{
    protected Drawable drawable;
    private Point position;
    
    public DrawCommand(Drawable drawable, Point position)
    {
        this.drawable = drawable;
        this.position = position;
    }
    
    @Override
    public void execute()
    {
        this.drawable.draw(this.position.x, this.position.y);
    }
}
