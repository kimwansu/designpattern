package ch08.tablefactory;

import ch08.factory.*;

public class TableLink extends Link
{
    public TableLink(String caption, String url)
    {
        super(caption, url);
    }
    
    public String makeHTML()
    {
        return "  <td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
