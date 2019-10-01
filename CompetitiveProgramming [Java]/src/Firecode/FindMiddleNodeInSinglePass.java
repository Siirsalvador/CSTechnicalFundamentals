package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-10
 */
public class FindMiddleNodeInSinglePass {
    public ListNode findMiddleNode(ListNode head) {
        ListNode mid = head;
        int count = 0;
        if (head == null) return null;

        while (head.next != null) {
            if (count % 2 == 1) mid = mid.next;
            head = head.next;
            count++;
        }

        return mid;
    }

    public ListNode findMiddleNode2(ListNode head) {

        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args){}

}
