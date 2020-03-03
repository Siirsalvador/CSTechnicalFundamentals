package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-27
 */
public class MergeSortListNode {

    public ListNode mergeTwoSortedListRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        //else check which is smaller and add to listnode
        ListNode head = null;
        if(l1.data < l2.data){
            head =  new ListNode(l1.data);
            head.next = mergeTwoSortedListRecursive(l1.next, l2);
        }else{
            head = new ListNode(l2.data);
            head.next = mergeTwoSortedListRecursive(l1, l2.next);
        }

        return head;
    }
}
