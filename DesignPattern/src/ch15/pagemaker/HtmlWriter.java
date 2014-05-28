package ch15.pagemaker;

import java.io.Writer;
import java.io.IOException;

public class HtmlWriter
{
    private Writer writer;
    
    public HtmlWriter(Writer writer)
    {
        this.writer = writer;
    }
    
    public void title(String title) throws IOException
    {
        this.writer.write("<html>");
        this.writer.write("<head>");
        this.writer.write("<title>" + title + "</title");
        this.writer.write("</head>");
        this.writer.write("<body>\n");
        this.writer.write("<h1>" + title + "</h1>\n");
    }
    
    public void paragraph(String msg) throws IOException
    {
        this.writer.write("<p>" + msg + "</p>\n");
    }
    
    public void link(String href, String caption) throws IOException
    {
        this.paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }
    
    public void mailto(String mailAddr, String userName) throws IOException
    {
        this.link("mailto:" + mailAddr, userName);
    }
    
    public void close() throws IOException
    {
        this.writer.write("</body>");
        this.writer.write("</html>\n");
        this.writer.close();
    }
}
