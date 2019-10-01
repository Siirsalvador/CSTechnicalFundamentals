package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-29
 */
public class DelLinkedListTail {

    public ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null) return null;

        //Loop through until head.next.next == null;
        //set head.next = null

        ListNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;
        return head;
    }
}
