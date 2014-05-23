package ch07;

public class TextBuilder extends Builder
{
    private StringBuffer buffer = new StringBuffer();
    
    @Override
    public void buildTitle(String title)
    {
        this.buffer.append("=================================================\n");
        this.buffer.append("¡º" + title + "¡»\n");
        this.buffer.append("\n");
    }
    
    @Override
    public void buildString(String str)
    {
        this.buffer.append("¡á " + str + "\n");
        this.buffer.append("\n");
    }
    
    @Override
    public void buildItems(String[] items)
    {
        for (int i =0; i < items.length; i++) {
            this.buffer.append("¡¤" + items[i] + "\n");
        }
        this.buffer.append("\n");
    }
    
    @Override
    public Object buildResult()
    {
        this.buffer.append("=================================================\n");
        return this.buffer.toString();
    }
    
}
