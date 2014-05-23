package ch04.idcard;

import ch04.framework.*;
import java.util.*;

public class IDCardFactory extends Factory
{
    private Vector<String> owners = new Vector<String>();
    
    protected Product createProduct(String owner)
    {
        return new IDCard(owner);
    }
    
    protected void registerProduct(Product product)
    {
        this.owners.add(((IDCard)product).getOwner());
    }
    
    public Vector<String> getOwners()
    {
        return this.owners;
    }
}
