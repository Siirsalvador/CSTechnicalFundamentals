package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-19
 */
public class RemoveElementsLinkedList {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        while (head.val == val) {
            head = head.next;

            if (head == null) return null;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {

            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }

            curr = prev.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}