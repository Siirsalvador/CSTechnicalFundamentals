package PhoneScreens.AmazonBloombergPalantir;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class FlattenMultilevelDoublyLinkedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.prev = node;

        node.next.next = new Node(3);
        node.next.next.prev = node.next;

        node.next.next.child = new Node(7);
        Node child = node.next.next.child;
        child.next = new Node(8);
        child.next.prev = child;
        child.next.child = new Node(11);
        child.next.child.next = new Node(12);
        child.next.child.next.prev = child.next.child;

        child.next.next = new Node(9);
        child.next.next.prev = child.next;

        child.next.next.next = new Node(10);
        child.next.next.next.prev = child.next.next;

        Node curr = node.next.next;
        curr.next = new Node(4);
        curr.next.prev = curr;

        curr.next.next = new Node(5);
        curr.next.next.prev = curr.next;

        curr.next.next.next = new Node(6);
        curr.next.next.next.prev = curr.next.next;

        Node res = flatten(node);
        System.out.println(res.val);

    }

    public static Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        Node psuedoHead = new Node(0, head, null, null);
        Node prev = psuedoHead;

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) {
                stack.push(curr.next);
            }

            if (curr.child != null) {
                stack.push(curr.child);
            }

            curr.child = null;
            prev = curr;
        }

        psuedoHead.next.prev = null;
        return psuedoHead.next;
    }

    public static Node flatten2(Node head) {

        /*

        Get child
        Get right
        Get left

        flatten(child)
        flatten(right)

        head.right = child
        child.right = left;
        child.left = head;

        */
        helper(head);
        return head;
    }

    private static void helper(Node head) {
        if (head == null) return;

        Node next = head.next;
        Node child = head.child;

        helper(child);
        helper(next);

        head.next = child;
        head.child = null;
        if (child != null) child.prev = head;

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = next;
        if (next != null) next.prev = curr;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        Node(int val) {
            this.val = val;
        }
    }
}

