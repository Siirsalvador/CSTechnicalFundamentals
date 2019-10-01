package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-29
 */
public class FindNthNodeFromEnd {
    public static ListNode findNthNodeFromEnd(ListNode head, int n) {
    /*if(head == null || n < 0) return null;

    //3->2->1->0->1->2->3
    ListNode curr = head;
    int length = 1;

    while(curr.next != null){
        curr = curr.next;
        length++;
    }

    if(n > length) return null;

    int itemIdx = 0;
    curr = head;

    while(itemIdx != (length - n)){
        curr = curr.next;
        itemIdx++;
    }

    return curr; */

        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode findNthNodeFromEndEff(ListNode head, int n) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode nthNode = head;

        for (int i = 0; i < n; i++) {
            if (curr == null) return null;
            curr = curr.next;
        }

        while (curr != null) {
            curr = curr.next;
            nthNode = nthNode.next;
        }

        return nthNode;
    }

    public static ListNode findNthNodeFromEndEff2(ListNode head, int n) {
        ListNode previous = head;
        while (head != null) {
            if (n-- <= 0) {
                previous = previous.next;
            }
            head = head.next;
        }
        return n <= 0 ? previous : null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(findNthNodeFromEndEff(head, 6).data);
    }
}
