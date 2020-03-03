package PhoneScreens.Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-12
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Integer> nodeToIdx = new HashMap<>();
        Node curr = head;
        int idx = 0;
        while (curr != null) {
            nodeToIdx.put(curr, idx);
            curr = curr.next;
            idx++;
        }

        HashMap<Integer, Integer> idxToPointer = new HashMap<>();
        curr = head;
        idx = 0;
        while (curr != null) {
            idxToPointer.put(idx, nodeToIdx.get(curr.random));
            curr = curr.next;
            idx++;
        }

        HashMap<Integer, Node> idxToNode = new HashMap<>();
        Node newHead = new Node(head.val);
        Node node = newHead;
        idxToNode.put(0, newHead);

        curr = head.next;
        idx = 1;
        while (curr != null) {
            node.next = new Node(curr.val);
            node = node.next;
            curr = curr.next;

            idxToNode.put(idx, node);
            idx++;
        }

        for (Map.Entry<Integer, Integer> entry : idxToPointer.entrySet()) {

            if (entry.getValue() != null) {
                Node randomNode = idxToNode.get(entry.getValue());
                Node currNode = idxToNode.get(entry.getKey());
                currNode.random = randomNode;
            }

        }

        return newHead;
    }

    // Time: O(N)
    // Space: O(N)
    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> oldToNewNodes = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            oldToNewNodes.put(curr, newNode);

            curr = curr.next;
        }

        for (Map.Entry<Node, Node> entry : oldToNewNodes.entrySet()) {

            Node oldNode = entry.getKey();
            Node oldNext = oldNode.next;
            Node oldRandom = oldNode.random;

            Node newNode = entry.getValue();
            newNode.next = oldToNewNodes.get(oldNext);
            newNode.random = oldRandom == null ? null : oldToNewNodes.get(oldRandom);
        }

        return oldToNewNodes.get(head);
    }

    // Time: O(N)
    // Space: O(1)
    public Node copyRandomList3(Node head) {
        if (head == null) return null;

        //Create a new weaved list with old and new Nodes.
        //A->B->C becomes A->A'->B->B'->C->C'
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);

            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        // Link random pointers for newNodes
        // newNodeA.random = oldNodeA.random.next
        while (curr != null) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
            curr = curr.next.next;
        }

        //Unweave linked list to get old list and newly formed list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node oldList = head;
        Node newList = head.next;
        Node newHeadToReturn = head.next;

        while (oldList != null) {
            oldList.next = oldList.next.next;
            newList.next = (newList.next == null) ? null : newList.next.next;

            oldList = oldList.next;
            newList = newList.next;
        }


        return newHeadToReturn;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


