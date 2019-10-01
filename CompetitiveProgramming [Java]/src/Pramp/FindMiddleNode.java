package Pramp;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class FindMiddleNode {

    public ListNode findMiddleNode(ListNode head) {

        /*
            Initialize mid element as head; counter == 0
            if counter is odd, move mid (mid = mid.next)
            return mid
        */

        ListNode mid = head;
        ListNode currHead = head;
        int count = 0;
        if (head == null) return null;

        while (currHead.next != null) {
            if (count % 2 == 1) mid = mid.next;
            currHead = currHead.next;
            count++;
        }

        return mid;
    }

    public ListNode findMiddleNode2(ListNode head) {

        /*
            Move one element by one pointer, and the other by 2
            O(n/2)
        */

        ListNode slow = head;
        ListNode fast = head;
        if (head == null) return null;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

class ListNode {
    private int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
    }
}