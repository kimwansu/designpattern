package ch21;

public class PrinterProxy implements Printable
{
    private String name;
    private Printer real;
    
    public PrinterProxy() {}
    
    public PrinterProxy(String name)
    {
        this.name = name;
    }
    
    public synchronized void setPrinterName(String name)
    {
        if (this.real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }
    
    public String getPrinterName()
    {
        return this.name;
    }
    
    public void print(String string)
    {
        this.realize();
        this.real.print(string);
    }
    
    private synchronized void realize()
    {
        if (this.real == null) {
            this.real = new Printer(this.name);
        }
    }
}
