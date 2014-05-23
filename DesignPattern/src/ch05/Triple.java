package ch05;

public class Triple
{
    private static Triple[] instance = new Triple[] {
        new Triple(0), new Triple(1), new Triple(2)
    };
    
    private int id;
    
    private Triple(int id)
    {
        this.id = id;
    }
    
    public Triple getInstance(int id)
    {
        return instance[id];
    }
}