package ch16;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague
{
    private static final long serialVersionUID = 5632094168530475114L;
    
    private Mediator mediator;
    
    public ColleagueButton(String caption)
    {
        super(caption);
    }

    public void setMediator(Mediator mediator)
    {
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled)
    {
        this.setEnabled(enabled);
    }
    
}
