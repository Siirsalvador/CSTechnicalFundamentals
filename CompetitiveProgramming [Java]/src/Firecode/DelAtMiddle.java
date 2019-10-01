package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class DelAtMiddle {

    public static ListNode deleteAtMiddle(ListNode head, int position) {

        if (head == null) return null;

        if (position == 1) {
            head = head.next;
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;
        int count = 1;

        while (currNode != null) {

            if (count == position) {
                prevNode.next = currNode.next;
                return head;
            } else {
                prevNode = currNode;
                currNode = currNode.next;
            }

            count++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

        ListNode newNode = deleteAtMiddle(listNode, 1);
        while (newNode != null) {
            System.out.println(newNode.data);
            newNode = newNode.next;
        }
    }

}

class ListNode {
    ListNode next;
    int data;

    ListNode(int data) {
        this.data = data;
    }
}
