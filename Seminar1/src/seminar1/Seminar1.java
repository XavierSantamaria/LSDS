/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminar1;

/**
 *
 * @author u137543
 */
public class Seminar1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String seedPage = "http://en.wikipedia.org";
        
        Crawler craw = new Crawler();
        craw.crawling(seedPage);
    }
    
}
