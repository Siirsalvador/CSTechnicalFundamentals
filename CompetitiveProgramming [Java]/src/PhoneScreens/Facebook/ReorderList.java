package PhoneScreens.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-30
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;

        int idx = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(idx, curr);
            curr = curr.next;
            idx++;
        }

        int start = 0;
        int stop = idx - 1;

        ListNode prev = null;
        while (start <= stop) {
            ListNode first = map.get(start);
            ListNode second = map.get(stop);

            first.next = null;
            second.next = null;

            if (first != second) first.next = second;

            if (prev != null) prev.next = first;
            prev = second;

            start++;
            stop--;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}