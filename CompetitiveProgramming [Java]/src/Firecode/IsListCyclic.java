package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-04
 */
public class IsListCyclic {

    public Boolean isCyclic(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow.data == fast.data) return true;
        }

        return false;
    }
}
