package Firecode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-29
 */
public class IsLinkedListPalindrome {

    //3->2->1->0->1->2->3
    private static Boolean isListPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        //Find mid
        ListNode mid = head;
        ListNode curr = head;
        int count = 0;
        while(curr.next != null){
            if (count % 2 == 1) mid = mid.next;
            curr = curr.next;
            count++;
        }

        //Copy from mid to last element into list
        ArrayList<ListNode> nodeList = new ArrayList<>();
        ListNode fromMid = mid;
        nodeList.add(fromMid);
        while(fromMid.next != null){
            fromMid = fromMid.next;
            nodeList.add(fromMid);
        }

        //Reverse list
        Collections.reverse(nodeList);
        if(count % 2 != 0) nodeList.remove(nodeList.size() - 1);

        //Compare from head to mid
        curr = head;
        for (ListNode listNode : nodeList) {
            if (curr.data != listNode.data) return false;
            curr = curr.next;
        }

        return true;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(3);

        System.out.println(isListPalindrome(head));
    }
}
