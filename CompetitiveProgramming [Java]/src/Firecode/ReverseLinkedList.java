package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-29
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ArrayList<ListNode> nodes = new ArrayList<>();
        nodes.add(head);

        while (head.next != null) {
            head = head.next;
            nodes.add(head);
        }

        int size = nodes.size() - 1;
        ListNode curr = null;
        for (int i = size; i >= 0; i--) {
            ListNode next = nodes.get(i);
            next.next = null;

            if (curr != null) curr.next = next;
            curr = next;
        }

        return nodes.get(size);
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            ListNode newTail = newHead;
            newHead = new ListNode(head.data);
            newHead.next = newTail;

            head = head.next;
        }

        return newHead;
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode currentNode = head;
        ListNode previousNode = null;

        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        root.next = new ListNode(1);
//        root.next.next = new ListNode(4);
//        root.next.next.next = new ListNode(2);
//        root.next.next.next.next = new ListNode(3);

        ListNode head = reverseList(root);
        System.out.println(head.data);
    }
}
