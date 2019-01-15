/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminar1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

    private static final int MAX_PAGES_TO_SEARCH = 1000;
    private LinkedList<String> pagesToVisit = new LinkedList<String>();
    private Set<String> pagesVisited = new HashSet<String>();

    public void crawling(String url) {
        // mirar si no me excedido de las 1000 paginas
        // si la pagina de listas esta vacia meto la url
        // si no esta vacia la añado al final y crawleo la siguiente

        while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
            
            String currentURL;
            
            // Crawleo si no tengo pa visitar:
            if (this.pagesToVisit.isEmpty()) {
                currentURL = url;
                this.pagesVisited.add(url);
            }else {
                currentURL = nextURL();
            }
            // La parseo
            parsing(currentURL);
        }

    }
    public String nextURL(){
        // Devuelve la url que es la que tengo que crawlear
        String nextUrl;
        do{
            nextUrl = this.pagesToVisit.removeFirst(); // Remove first element
        }while(this.pagesVisited.contains(nextUrl)); // si ya la hemos visitado cogemos la siguiente
        this.pagesVisited.add(nextUrl);      
        return nextUrl;
    }
    
    public boolean parsing(String url){
        try{
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a");
            
            for (Element newLink : links){
                System.out.println(newLink.attr("abs:href"));
                this.pagesToVisit.add(newLink.attr("abs:href"));
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
