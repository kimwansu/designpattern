package ch16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

public class ColleagueTextField extends TextField implements Colleague, TextListener
{
    private static final long serialVersionUID = -4186017244083665177L;
    
    private Mediator mediator;
    
    public ColleagueTextField(String text, int columns)
    {
        super(text, columns);
    }
    
    public void setMediator(Mediator mediator)
    {
        this.mediator = mediator;
    }
    
    public void setColleagueEnabled(boolean enabled)
    {
        this.setEnabled(enabled);
        this.setBackground(enabled ? Color.white : Color.lightGray);
    }
    
    public void textValueChanged(TextEvent e)
    {
        this.mediator.colleagueChanged(this);
    }
}
