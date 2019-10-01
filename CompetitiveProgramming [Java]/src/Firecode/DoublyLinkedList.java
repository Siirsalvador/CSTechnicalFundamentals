package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-09
 */
public class DoublyLinkedList {

    public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        if (head == null) return null;

        DoublyLinkedNode node = new DoublyLinkedNode(data);

        //1 ==> null , insert 4 at position 2

        //if pos = 1
        if (pos == 1) {
            node.next = head;
            head.prev = node;
            return node;
        }

        DoublyLinkedNode curr = head; //null
        DoublyLinkedNode prev = null; //1
        int count = 1; //2
        while (curr != null && count != pos) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        //if pos is out of bounds
        if (count != pos) return head;

        //if at end
        if (curr == null) {
            prev.next = node;
            node.prev = prev;
            return head;

        } else {

            //if at middle
            //prev curr
            //prev.next = curr
            //curr.prev = prev
            //prev new curr
            //prev.next = new
            //new.prev = prev
            //new.next = curr
            //curr.prev = new
            prev.next = node;
            node.prev = prev;
            node.next = curr;
            curr.prev = node;
            return head;
        }

    }

    public DoublyLinkedNode insertAtPosition(DoublyLinkedNode head, int data, int pos) {
        DoublyLinkedNode n = new DoublyLinkedNode(data);
        if (pos == 1) {
            n.next = head;
            if (head != null) head.prev = n;
            return n;
        }
        if (pos < 1 || head == null) return head;

        DoublyLinkedNode curr = head;
        while (pos - 1 > 1) {
            pos--;
            curr = curr.next;
            if (curr == null) return head;
        }

        DoublyLinkedNode next = curr.next;
        curr.next = n;
        n.next = next;
        n.prev = curr;
        if (next != null) next.prev = n;

        return head;
    }

    public DoublyLinkedNode deleteAtPos(DoublyLinkedNode head, int pos) {
        if (pos < 1 || head == null) return head;

        DoublyLinkedNode curr = head;
        if (pos == 1) {
            curr = head.next;
            curr.prev = null;
            return curr;
        }

        DoublyLinkedNode prev = null;
        while (pos > 1) {
            pos--;
            prev = curr;
            curr = curr.next;
            if (curr == null) return head;
        }

        DoublyLinkedNode next = curr.next;
        curr.prev = null;
        curr.next = null;

        if (next != null) {
            prev.next = next;
            next.prev = prev;
        } else {
            prev.next = null;
        }

        return head;
    }

    public DoublyLinkedNode deleteAtPos3(DoublyLinkedNode head, int pos) {
        if (head == null) return null;

        if (pos == 1) {
            head = head.next;
            return head;
        }

        DoublyLinkedNode curr = head;
        while (pos > 1 && curr.next != null) {
            curr = curr.next;
            pos--;
        }

        DoublyLinkedNode prev = curr.prev;
        if (prev == null) return head;
        if (curr.next != null) {
            prev.next = curr.next;
            prev.next.prev = prev;
        } else {
            prev.next = null;
        }

        return head;
    }

    static class DoublyLinkedNode {
        int data;
        DoublyLinkedNode next;
        DoublyLinkedNode prev;

        public DoublyLinkedNode(int data) {
            this.data = data;
        }
    }

}
