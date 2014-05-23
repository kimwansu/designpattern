package ch06.framework;

import java.util.*;

public class Manager
{
    private Hashtable<String, Product> showCase = new Hashtable<String, Product>();
    
    public void register(String name, Product proto)
    {
        showCase.put(name, proto);
    }
    
    public Product create(String protoName)
    {
        Product p = this.showCase.get(protoName);
        return p.createClone();
    }
}
