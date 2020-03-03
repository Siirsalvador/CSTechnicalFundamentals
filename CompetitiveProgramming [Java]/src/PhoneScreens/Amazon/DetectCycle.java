package PhoneScreens.Amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-16
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (!visited.add(curr)) return curr;
            curr = curr.next;
        }

        return null;
    }

    /*
        Floyd's Algorithm
     */

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;

        ListNode intersect = findIntersection(head);
        if (intersect == null) return null;

        ListNode curr = head;
        while (curr != null && intersect != null) {
            curr = curr.next;
            intersect = intersect.next;

            if (curr == intersect) return curr;
        }

        return null;
    }

    private ListNode findIntersection(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return slow;
        }

        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}