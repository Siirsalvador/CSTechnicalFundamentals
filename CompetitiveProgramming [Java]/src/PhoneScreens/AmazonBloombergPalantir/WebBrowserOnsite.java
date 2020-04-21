package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-10
 */
public class WebBrowserOnsite {

    Map<String, Page> map;
    Page head;
    Page tail;

    WebBrowserOnsite() {
        map = new HashMap<>();
    }

    void addPage(String url) {
        if (head == null) {
            head = new Page(url);
            tail = head;
            map.put(url, tail);
        } else {
            if (map.containsKey(url)) {
                Page exists = map.get(url);

                if (exists.next == null)
                    return;

                else if (exists.prev == null)
                    head = head.next;

                else {
                    exists.prev.next = exists.next;
                    exists.next.prev = exists.prev;
                }
            }

            tail.next = new Page(url);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    List<String> viewHistory() {

        List<String> l = new ArrayList<>();
        Page curr = head;
        while (curr != null) {
            l.add(curr.url);
            curr = curr.next;
        }

        return l;
    }
}

class Page {
    Page next;
    Page prev;
    String url;

    Page(String url) {
        this.url = url;
    }
}
