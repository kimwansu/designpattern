package ch22.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import ch22.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable
{
    private static final long serialVersionUID = -1331774606170582819L;
    
    private Color color = Color.red;
    private int radius = 6;
    private MacroCommand history;
    
    public DrawCanvas(int width, int height, MacroCommand history)
    {
        this.setSize(width, height);
        this.setBackground(Color.white);
        this.history = history;
    }
    
    public void paint(Graphics g)
    {
        this.history.execute();
    }
    
    public void draw(int x, int y)
    {
        Graphics g = this.getGraphics();
        g.setColor(this.color);
        g.fillOval(x - this.radius, y - this.radius, this.radius * 2, this.radius * 2);
    }
}
