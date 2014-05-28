package ch20;

public class BigString
{
    private BigChar[] bigChars;
    
    public BigString(String string)
    {
        this.bigChars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < this.bigChars.length; i++) {
            this.bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }
    
    public void print()
    {
        for (int i = 0; i < this.bigChars.length; i++) {
            this.bigChars[i].print();
        }
    }
}
