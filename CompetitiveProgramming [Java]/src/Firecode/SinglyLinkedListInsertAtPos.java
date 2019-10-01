package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-29
 */
public class SinglyLinkedListInsertAtPos {

    public static ListNode insertAtPosition(ListNode head, int data, int pos) {
        ListNode node = new ListNode(data);
        if (head == null) return node;

        if (pos == 1) {
            node.next = head;
            return node;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
            pos--;

            if (pos == 1) break;
        }

        //Not at the end
        if (pos == 1) {
            prev.next = node;
            node.next = curr;
        } else {
            //At the end
            curr.next = node;
        }

        return head;
    }

    public static ListNode insertAtPosition2(ListNode head, int data, int pos) {
        // Add your code below this line. Do not modify any other code.
        if (head == null) {
            return new ListNode(data);
        }
        if (pos == 1) {
            ListNode newNode = new ListNode(data);
            newNode.next = head;
            return newNode;
        }

        head.next = insertAtPosition2(head.next, data, pos-1);
        return head;
        // Add your code above this line. Do not modify any other code.
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        root.next = new ListNode(1);
        root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(3);

        ListNode head = insertAtPosition2(root, 8, 6);
        System.out.println(head.data);

    }
}
