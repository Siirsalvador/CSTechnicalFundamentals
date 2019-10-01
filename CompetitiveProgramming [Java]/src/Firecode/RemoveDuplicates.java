package Firecode;

import java.util.HashSet;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-07
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next.next.next = new ListNode(1);

        removeDuplicates(root);
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;
        HashSet<Integer> dataStore = new HashSet<>();
        dataStore.add(head.data);

        ListNode curr = head;
        while (curr.next != null) {

            if (dataStore.contains(curr.next.data)) {
                curr.next = curr.next.next;
            } else {
                dataStore.add(curr.next.data);
                curr = curr.next;
            }

        }

        return head;
    }
}
