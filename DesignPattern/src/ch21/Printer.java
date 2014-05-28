package ch21;

public class Printer implements Printable
{
    private String name;
    
    public Printer()
    {
        this.heavyJob("Printer�� �ν��Ͻ��� ���� ��");
    }
    
    public Printer(String name)
    {
        this.name = name;
        this.heavyJob("Printer�� �ν��Ͻ�(" + name + ")�� ������");
    }
    
    public void setPrinterName(String name)
    {
        this.name = name;
    }
    
    public String getPrinterName()
    {
        return this.name;
    }
    
    public void print(String string)
    {
        System.out.println("=== " + this.name + " ===");
        System.out.println(string);
    }
    
    private void heavyJob(String msg)
    {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println(".");
        }
        System.out.println("�Ϸ�.");
    }
}
