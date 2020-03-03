package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class SinglyLinkedList {

    public Node deleteNode(Node head, int val) {
        if (head == null) return null;

        if (head.v == val) return head.next;

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {

            if (curr.v == val) {
                prev.next = curr.next;
                return head;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    class Node {
        int v;
        Node next;
    }
}
