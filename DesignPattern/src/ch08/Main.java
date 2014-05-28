package ch08;

import ch08.factory.*;

public class Main
{
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listfactory.ListFactory");
            System.out.println("Example 2: java Main tablefactory.TableFactory");
            System.exit(0);
        }
        
        Factory factory = Factory.getFactory(args[0]);
        
        Link joins = factory.createLink("중앙일보", "http://www.joins.com/");
        Link hani = factory.createLink("한겨레 신문", "htttp://www.hani.co.kr/");
        
        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo! Japan", "http://www.yahoo.co.jp/");
        
        Link naver = factory.createLink("네이버", "http://www.naver.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");
        
        Tray trayNews = factory.createTray("신문");
        trayNews.add(joins);
        trayNews.add(hani);
        
        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(jp_yahoo);
        
        Tray traySearch = factory.createTray("검색엔진");
        traySearch.add(trayYahoo);
        traySearch.add(naver);
        traySearch.add(google);
        
        Page page = factory.createPage("LinkPage", "홍길동");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
