package ch11;

public abstract class Entry
{
    public abstract String getName();
    public abstract int getSize();
    
    public Entry add(Entry entry) throws FileTreatmentException
    {
        throw new FileTreatmentException();
    }
    
    public void printList()
    {
        this.printList("");
    }
    
    protected abstract void  printList(String prefix);
    
    public String toString()
    {
        return this.getName() + " (" + this.getSize() + ")";
    }
}
