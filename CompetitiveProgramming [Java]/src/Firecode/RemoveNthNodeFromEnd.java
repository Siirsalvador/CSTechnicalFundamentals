package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-07
 */
public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        removeNthFromEnd(root, 3);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return head;
            }
        }

        ListNode prev = null;
        while (fast != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            head = head.next;
            return head;
        }

        if (slow.next != null) {
            prev.next = slow.next;
        } else {
            prev.next = null;
        }

        return head;
    }

    public static ListNode removeNthFromEndEff(ListNode head, int n) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode run = head;

        for (int i = 0; i < n; i++) {
            if (run == null) return head;
            run = run.next;
        }
        if (run == null) return head.next;

        while (run.next != null) {
            curr = curr.next;
            run = run.next;
        }

        curr.next = curr.next.next;
        return head;
    }

}
