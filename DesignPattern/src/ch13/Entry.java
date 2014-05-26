package ch13;

import java.util.Iterator;

public abstract class Entry implements Acceptor
{
    public abstract String getName();
    public abstract int getSize();
    
    public Entry add(Entry entry) throws FileTreatmentException
    {
        throw new FileTreatmentException();
    }
    
    public Iterator<Entry> iterator() throws FileTreatmentException
    {
        throw new FileTreatmentException();
    }
    
    public String toString()
    {
        return this.getName() + " (" + this.getSize() + ")";
    }
}
