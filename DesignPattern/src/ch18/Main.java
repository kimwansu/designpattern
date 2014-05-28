package ch18;

import ch18.game.*;

public class Main
{
    public static void main(String[] args)
    {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.createMemento();
        
        for (int i = 0; i < 100; i++) {
            System.out.println("==== " + i);
            System.out.println("�� ����: " + gamer);
            
            gamer.bet();
            System.out.println("���� " + gamer.getMoney() + "���� �Ǿ����ϴ�.");
            
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("    (���� ���������� ������ ���¸� �����ص���)  ");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("    (���� �پ����� ������ ���·� ��������) ");
                gamer.restoreMemento(memento);
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            
            System.out.println();
        }
    }
}
