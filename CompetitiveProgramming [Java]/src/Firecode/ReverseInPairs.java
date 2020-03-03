package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-27
 */
public class ReverseInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        int temp = head.data;
        head.data = head.next.data;
        head.next.data = temp;

    /*
    switch out the int.
    reverse in pairs for head.next.next;
    */
        head.next.next = reverseInPairs(head.next.next);
        return head;
    }
}
