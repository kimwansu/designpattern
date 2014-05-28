package ch18.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Gamer
{
    private int money;
    private ArrayList<String> fruits = new ArrayList<String>();
    private Random random = new Random();
    private static String[] fruitsName = {
        "사과", "포도", "바나나", "귤",
    };
    
    public Gamer(int money)
    {
        this.money = money;
    }
    
    public int getMoney()
    {
        return this.money;
    }
    
    public void bet()
    {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            this.money += 100;
            System.out.println("돈이 증가했습니다.");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("돈이 반으로 줄었습니다.");
        } else if (dice == 6) {
            String f = this.getFruit();
            System.out.println("과일(" + f + ")을 받았습니다.");
            this.fruits.add(f);
        } else {
            System.out.println("아무 일도 일어나지 않았습니다.");
        }
    }
    
    public Memento createMemento()
    {
        Memento m = new Memento(this.money);
        Iterator<String> it = this.fruits.iterator();
        while (it.hasNext()) {
            String f = it.next();
            if (f.startsWith("맛있다")) {
                m.addFruit(f);
            }
        }
        return m;
    }
    
    public void restoreMemento(Memento memento)
    {
        this.money = memento.money;
        this.fruits = memento.fruits;
    }
    
    public String toString()
    {
        return "[money = " + this.money + ", fruits = " + this.fruits + "]";
    }
    
    private String getFruit()
    {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "맛있다";
        }
        return prefix + fruitsName[this.random.nextInt(fruitsName.length)];
    }
}
