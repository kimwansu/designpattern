package ch18.game;

import java.util.ArrayList;

public class Memento
{
    int money;
    ArrayList<String> fruits;
    
    Memento(int money)
    {
        this.money = money;
        this.fruits = new ArrayList<String>();
    }
    
    public int getMoney()
    {
        return this.money;
    }
    
    void addFruit(String fruit)
    {
        this.fruits.add(fruit);
    }
}
