package ch08.factory;

import java.io.*;
import java.util.ArrayList;

public abstract class Page
{
    protected String title;
    protected String author;
    protected ArrayList<Item> content = new ArrayList<Item>();
    
    public Page(String title, String author)
    {
        this.title = title;
        this.author = author;
    }
    
    public void add(Item item)
    {
        content.add(item);
    }
    
    public void output()
    {
        try {
            String fileName = this.title + ".html";
            Writer writer = new FileWriter(fileName);
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(fileName + "을 작성했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public abstract String makeHTML();
}
