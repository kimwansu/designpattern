package ch15.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker
{
    private PageMaker() {}
    
    public static void makeWelcomePage(String mailAddr, String fileName)
    {
        try {
            Properties mailProp = Database.getProperties("mailData");
            String userName = mailProp.getProperty(mailAddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Welcome to " + userName + "'s page!");
            writer.paragraph(userName + "�� �������� ���Ű� ȯ���մϴ�.");
            writer.paragraph("������ ��ٸ��� �ְڽ��ϴ�.");
            writer.mailto(mailAddr, userName);
            writer.close();
            System.out.println(fileName + " is created for " + mailAddr + " (" + userName + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
