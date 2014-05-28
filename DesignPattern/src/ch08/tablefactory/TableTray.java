package ch08.tablefactory;

import ch08.factory.*;
import java.util.Iterator;

public class TableTray extends Tray
{
    public TableTray(String caption)
    {
        super(caption);
    }
    
    public String makeHTML()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>\n");
        buffer.append(caption + "\n");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>\n");
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\""
                + tray.size() + "\"><b>" + caption + "</b></td>");
        buffer.append("</tr>");
        buffer.append("<tr>");
        Iterator<Item> it = tray.iterator();
        while (it.hasNext()) {
            Item item = (Item)it.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>\n");
        buffer.append("</td>\n");
        return buffer.toString();
    }
}
