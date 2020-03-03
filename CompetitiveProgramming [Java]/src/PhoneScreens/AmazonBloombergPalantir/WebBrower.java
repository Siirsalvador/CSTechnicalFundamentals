package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-19
 */
class WebBrower {

    WebPage head;
    WebPage tail;

    WebBrower() {
        this.head = null;
        this.tail = null;
    }

    void visit(String url) {
        if (head == null) {
            head = new WebPage(url);
            tail = head;
        } else {

            deleteUrl(url);

            WebPage curr = head;
            while (curr.next != null) {
                curr = curr.next;

            }

            curr.next = new WebPage(url);
            tail = curr.next;
        }
    }

    private void deleteUrl(String url) {

        if (head.url.equals(url)) {
            head = head.next;
            return;
        }

        WebPage curr = head;
        while (curr.next != null) {

            if (curr.next.url.equals(url)) {
                curr.next = curr.next.next;
                curr.next.prev = curr;
                return;
            }

            curr = curr.next;
        }
    }

    void printTop5() {

        int i = 5;
        WebPage curr = tail;
        while (i > 0 && curr != null) {
            System.out.println(curr.url);
            curr = curr.prev;
            i--;
        }
    }
}

class WebPage {
    String url;
    WebPage prev;
    WebPage next;

    WebPage(String url) {
        this.url = url;
    }
}