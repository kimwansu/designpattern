package ch04.idcard;

import ch04.framework.*;

public class IDCard extends Product
{
    private String owner;
    
    IDCard(String owner)
    {
        System.out.println(owner + "�� ī�带 ����ϴ�.");
        this.owner = owner;
    }
    
    public void use()
    {
        System.out.println(this.owner + "�� ī�带 ����մϴ�.");
    }
    
    public String getOwner()
    {
        return this.owner;
    }
}