package PhoneScreens.AmazonBloombergPalantir;


import java.util.LinkedList;

/**
 * Question
 */

class BrowserHistory {

    private LinkedList<WebPage> webPages;

    BrowserHistory() {
        this.webPages = new LinkedList<>();
    }

    private void printUrlsInChronologicalOrder() {
        int size = webPages.size();
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(webPages.get(i).url);
        }
    }

    void visit(String url) {
        for (WebPage page : webPages) {
            if (page.url.equals(url)) {
                if (page.prev != null && page.next != null) page.prev.next = page.next;
                if (page.prev == null) page.next.prev = null;
            }
        }

        webPages.getLast().next = new WebPage(url);

    }

    void print() {
        this.printUrlsInChronologicalOrder();
    }

    class WebPage {
        String url;
        WebPage prev;
        WebPage next;

        WebPage(String url) {
            this.url = url;
        }
    }
}

class Solution {
    public static void main(String args[]) throws Exception {
        BrowserHistory hist = new BrowserHistory();
        hist.visit("bbc");
        hist.visit("cnn");
        hist.print();

        BrowserHistory hist2 = new BrowserHistory();
        hist.visit("abc");
        hist.visit("cde");
        hist.print();
    }

}
