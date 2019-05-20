package DataStructures.LinkedList.SinglyLinkedList;

public class LinkedListDS {
    Node head;

    /**
     * @param linkedListDS
     * @param data
     * @return the updated LinkedList
     * This function inserts new node at the end of the LinkedList
     */
    public static LinkedListDS insert(LinkedListDS linkedListDS, int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (linkedListDS.head == null) {
            linkedListDS.head = newNode;
        } else {
            Node lastItem = linkedListDS.head;
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
        return linkedListDS;
    }

    /**
     * @param linkedListDS
     * @param data
     * @return the update LinkedList with a new node at its head
     */
    public static LinkedListDS push(LinkedListDS linkedListDS, int data) {

        Node headNode = linkedListDS.head;
        if (headNode == null) {
            linkedListDS.head = new Node(data);
            return linkedListDS;
        }

        Node currentNode = new Node(data);
        currentNode.next = headNode;
        linkedListDS.head = currentNode;

        return linkedListDS;
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

    public static LinkedListDS deleteByKey(LinkedListDS linkedListDS, int key) {
        Node headNode = linkedListDS.head;
        Node previousNode = null;

        /**
         * @FirstCase:
         * If head node itself holds the key to be deleted
         */
        if (headNode != null && headNode.data == key) {
            linkedListDS.head = headNode.next;
            return linkedListDS;
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

        return linkedListDS;

    }

    public static LinkedListDS deleteByIndex(LinkedListDS linkedListDS, int index) {

        Node headNode = linkedListDS.head;
        Node previousNode = null;

        if (headNode != null && index == 0) {
            linkedListDS.head = headNode.next;
            return linkedListDS;
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

        return linkedListDS;
    }

    public static void printLinkedList(LinkedListDS linkedListDS) {
        Node headNode = linkedListDS.head;

        System.out.print("LinkedList: ");

        while (headNode != null) {

            System.out.print(headNode.data + " ");
            headNode = headNode.next;

        }

    }

    public static void main(String[] args) {
        LinkedListDS linkedListDS = new LinkedListDS();

        Node headNode = new Node(5);
        headNode.next = null;

        linkedListDS.head = headNode;
        insert(linkedListDS, 13);
        insert(linkedListDS, 12);

        printLinkedList(linkedListDS);

    }
}
