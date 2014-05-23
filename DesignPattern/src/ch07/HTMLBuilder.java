package ch07;

import java.io.*;

public class HTMLBuilder extends Builder
{
    private String fileName;
    private PrintWriter writer;
    
    @Override
    public void buildTitle(String title)
    {
        this.fileName = title + ".html";
        try {
            this.writer = new PrintWriter(new FileWriter(this.fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.writer.println("<html><head><title>" + title + "</title></head><body>");
    }
    
    @Override
    public void buildString(String str)
    {
        this.writer.println("<p>" + str + "</p>\n");
    }
    
    @Override
    public void buildItems(String[] items)
    {
        this.writer.println("<ul>\n");
        for (int i = 0; i < items.length; i++) {
            this.writer.println("<li>" + items[i] + "</li>\n");
        }
        this.writer.println("</ul>\n");
    }
    
    @Override
    public Object buildResult()
    {
        this.writer.println("</body></html>");
        this.writer.close();
        return this.fileName;
    }
    
}
