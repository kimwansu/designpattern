package ch22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import ch22.command.Command;
import ch22.command.MacroCommand;
import ch22.drawer.DrawCanvas;
import ch22.drawer.DrawCommand;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener
{
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400, 400, this.history);
    private JButton clearButton = new JButton("clear");
    
    public Main(String title)
    {
        super(title);
        
        this.addWindowListener(this);
        this.canvas.addMouseMotionListener(this);
        this.clearButton.addActionListener(this);
        
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(this.clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(this.canvas);
        this.getContentPane().add(mainBox);
        
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.clearButton) {
            this.history.clear();
            this.canvas.repaint();
        }
    }
    
    public void mouseMoved(MouseEvent e) {}
    
    public void mouseDragged(MouseEvent e)
    {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        this.history.append(cmd);
        cmd.execute();
    }
    
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowClosed(WindowEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeactivated(WindowEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowOpened(WindowEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
    public static void main(String[] args)
    {
        new Main("Command Pattern Sample");
    }
}
