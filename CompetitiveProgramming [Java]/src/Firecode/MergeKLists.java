package Firecode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-05
 */
public class MergeKLists {
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {

        PriorityQueue<ListNode> nodeList = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.data - n2.data;
            }
        });

        for (ListNode aNode : lists) {
            while (aNode != null) {
                ListNode temp = aNode.next;
                aNode.next = null;
                nodeList.offer(aNode);
                aNode = temp;
            }
        }

        ListNode head = nodeList.remove();
        ListNode curr = head;
        while (!nodeList.isEmpty()) {
            curr.next = nodeList.remove();
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(13);
        n1.next.next.next = new ListNode(45);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(5);
        n2.next.next = new ListNode(12);
        n2.next.next.next = new ListNode(14);

        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(n1);
        listNodes.add(n2);

        ListNode res = mergeKLists(listNodes);
        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }
}
