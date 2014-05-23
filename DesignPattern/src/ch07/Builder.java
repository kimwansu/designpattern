package ch07;

public abstract class Builder
{
    private boolean initialized = false;
    
    public void makeTitle(String title)
    {
        if (!this.initialized) {
            this.buildTitle(title);
            this.initialized = true;
        }
    }
    
    public void makeString(String str)
    {
        if (this.initialized) {
            this.buildString(str);
        }
    }
    
    public void makeItems(String[] items)
    {
        if (this.initialized) {
            this.buildItems(items);
        }
    }
    
    public Object getResult()
    {
        if (this.initialized) {
            return this.buildResult();
        } else {
            return null;
        }
    }
    
    protected abstract void buildTitle(String title);
    protected abstract void buildString(String str);
    protected abstract void buildItems(String[] items);
    protected abstract Object buildResult();
}
