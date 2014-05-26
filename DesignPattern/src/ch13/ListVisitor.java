package ch13;

import java.util.Iterator;

public class ListVisitor extends Visitor
{
    private String currentDir = "";
    
    public void visit(File file)
    {
        System.out.println(this.currentDir + "/" + file);
    }
    
    public void visit(Directory directory)
    {
        System.out.println(this.currentDir + "/" + directory);
        String saveDir = this.currentDir;
        this.currentDir += "/" + directory.getName();
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }
        this.currentDir = saveDir;
    }
}
