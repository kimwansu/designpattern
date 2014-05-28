package ch10;

public class Player
{
    private String name;
    private Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;
    
    public Player(String player, Strategy strategy)
    {
        this.name = player;
        this.strategy = strategy;
    }
    
    public Hand nextHand()
    {
        return this.strategy.nextHand();
    }
    
    public void win()
    {
        this.strategy.study(true);;
        this.winCount++;
        this.gameCount++;
    }
    
    public void lose()
    {
        this.strategy.study(false);
        this.loseCount++;
        this.gameCount++;
    }
    
    public void even()
    {
        this.gameCount++;
    }
    
    public String toString()
    {
        return "[" + this.name + ": " + this.gameCount + " games, " + this.winCount + " win, "
                + this.loseCount + " lose" + "]";
    }
}
