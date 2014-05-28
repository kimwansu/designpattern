package ch12;

public class StringDisplay extends Display
{
    private String string;
    
    public StringDisplay(String string)
    {
        this.string = string;
    }
    
    public int getColumns()
    {
        return this.string.getBytes().length;
    }
    
    public int getRows()
    {
        return 1;
    }
    
    public String getRowText(int row)
    {
        if (row == 0) {
            return this.string;
        } else {
            return null;
        }
    }
}
