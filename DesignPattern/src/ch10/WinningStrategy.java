package ch10;

import java.util.Random;

public class WinningStrategy implements Strategy
{
    private Random random;
    private boolean won = false;
    private Hand prevHand;
    
    public WinningStrategy(int seed)
    {
        this.random = new Random(seed);
    }
    
    public Hand nextHand()
    {
        if (!this.won) {
            this.prevHand = Hand.getHand(random.nextInt(3));
        }
        return this.prevHand;
    }
    
    public void study(boolean win)
    {
        this.won = win;
    }
}
