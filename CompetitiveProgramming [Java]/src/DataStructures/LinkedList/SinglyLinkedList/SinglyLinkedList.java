package DataStructures.LinkedList.SinglyLinkedList;

public class SinglyLinkedList {
    Node head;

    /**
     * @param singlyLinkedList
     * @param data
     * @return the updated LinkedList
     * This function inserts new node at the end of the LinkedList
     */
    public static SinglyLinkedList insert(SinglyLinkedList singlyLinkedList, int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (singlyLinkedList.head == null) {
            singlyLinkedList.head = newNode;
        } else {
            Node lastItem = singlyLinkedList.head;
            while (lastItem.next != null) {
                lastItem = lastItem.next;
            }
            lastItem.next = newNode;
        }

        /**
         * What I was confused about was that, there didn't seem to be any direct call to add the newly added node to the linkedlist
         * What put me at ease was understanding that even if I create a new Node object to be equal to a node in the linkedlist,
         * they still contain the same reference.
         */
        return singlyLinkedList;
    }

    /**
     * @param singlyLinkedList
     * @param data
     * @return the update LinkedList with a new node at its head
     */
    public static SinglyLinkedList push(SinglyLinkedList singlyLinkedList, int data) {

        Node headNode = singlyLinkedList.head;
        if (headNode == null) {
            singlyLinkedList.head = new Node(data);
            return singlyLinkedList;
        }

        Node currentNode = new Node(data);
        currentNode.next = headNode;
        singlyLinkedList.head = currentNode;

        return singlyLinkedList;
    }

    /**
     * @param previousNode
     * @param data         This method adds a new node after any given node
     */
    public static void insertAfter(Node previousNode, int data) {
        if (previousNode == null) {
            System.out.println("Previous node cannot be null");
        }

        Node newNode = new Node(data);

        assert previousNode != null;
        newNode.next = previousNode.next;
        previousNode.next = newNode;

    }

    public static SinglyLinkedList deleteByKey(SinglyLinkedList singlyLinkedList, int key) {
        Node headNode = singlyLinkedList.head;
        Node previousNode = null;

        /**
         * @FirstCase:
         * If head node itself holds the key to be deleted
         */
        if (headNode != null && headNode.data == key) {
            singlyLinkedList.head = headNode.next;
            return singlyLinkedList;
        }

        /**
         * @SecondCase:
         * If the key is somewhere other than at head
         * Search for the key to be deleted,
         * keep track of the previous node as it is needed to change currNode.next
         */
        Node currentNode = headNode;
        while (currentNode != null && currentNode.data != key) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            assert previousNode != null;
            previousNode.next = currentNode.next;
        }

        if (currentNode == null) {
            System.out.println("The key was not found");
        }

        return singlyLinkedList;

    }

    public static SinglyLinkedList deleteByIndex(SinglyLinkedList singlyLinkedList, int index) {

        Node headNode = singlyLinkedList.head;
        Node previousNode = null;

        if (headNode != null && index == 0) {
            singlyLinkedList.head = headNode.next;
            return singlyLinkedList;
        }

        Node currentNode = headNode;
        int counter = 0;

        while (currentNode != null) {
            if (counter == index) {
                previousNode.next = currentNode.next;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
        }

        if (currentNode == null) {
            System.out.println("Index not found");
        }

        return singlyLinkedList;
    }

    public static void printLinkedList(SinglyLinkedList singlyLinkedList) {
        Node headNode = singlyLinkedList.head;

        System.out.print("LinkedList: ");

        while (headNode != null) {

            System.out.print(headNode.data + " ");
            headNode = headNode.next;

        }

    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        Node headNode = new Node(5);
        headNode.next = null;

        singlyLinkedList.head = headNode;
        insert(singlyLinkedList, 13);
        insert(singlyLinkedList, 12);

        printLinkedList(singlyLinkedList);

    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
    }
}
