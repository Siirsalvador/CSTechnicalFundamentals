package DataStructures.LinkedList.DoublyLinkedList;

public class DoublyLinkedListDS {
    private DoublyLinkedListNode head;

    private static void push(DoublyLinkedListDS doublyLinkedListDS, int data) {

        DoublyLinkedListNode headNode = doublyLinkedListDS.head;
        if (headNode == null) {
            doublyLinkedListDS.head = new DoublyLinkedListNode(data);
            doublyLinkedListDS.head.nextNode = null;
            doublyLinkedListDS.head.previousNode = null;
            return;
        }

        headNode = doublyLinkedListDS.head;

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        headNode.previousNode = newNode;
        newNode.nextNode = headNode;
        doublyLinkedListDS.head = newNode;
    }

    private static void insertAfter(DoublyLinkedListNode nodeToInsertAfter, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        assert nodeToInsertAfter != null;
        newNode.nextNode = nodeToInsertAfter.nextNode;
        nodeToInsertAfter.nextNode = newNode;
        newNode.previousNode = nodeToInsertAfter;

        if (newNode.nextNode != null) {
            newNode.nextNode.previousNode = newNode;
        }

    }

    private static void append(DoublyLinkedListDS doublyLinkedListDS, int data) {
        DoublyLinkedListNode headNode = doublyLinkedListDS.head;
        if (headNode == null) {
            doublyLinkedListDS.head = new DoublyLinkedListNode(data);
            return;
        }

        DoublyLinkedListNode currentNode = headNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = new DoublyLinkedListNode(data);
        currentNode.nextNode.previousNode = currentNode;
    }

    private static void deleteNode(DoublyLinkedListNode headNode, DoublyLinkedListNode nodeToBeDeleted) {

        if (headNode == null || nodeToBeDeleted == null) {
            return;
        }

        if (headNode == nodeToBeDeleted) {
            nodeToBeDeleted = headNode.nextNode;
        }

        if (nodeToBeDeleted.nextNode != null) {
            nodeToBeDeleted.nextNode.previousNode = nodeToBeDeleted.previousNode;
        }

        if (nodeToBeDeleted.previousNode != null) {
            nodeToBeDeleted.previousNode.nextNode = nodeToBeDeleted.nextNode;
        }

    }

    public static void main(String[] args) {
        DoublyLinkedListDS doublyLinkedListDS = new DoublyLinkedListDS();
        doublyLinkedListDS.head = new DoublyLinkedListNode(10);

        DoublyLinkedListNode eachNode = doublyLinkedListDS.head;
        while (eachNode != null) {
            System.out.println(eachNode.data);
            eachNode = eachNode.nextNode;
        }

        push(doublyLinkedListDS, 12);

        eachNode = doublyLinkedListDS.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();

        insertAfter(doublyLinkedListDS.head.nextNode, 25);

        eachNode = doublyLinkedListDS.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();

        append(doublyLinkedListDS, 3500);

        eachNode = doublyLinkedListDS.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();

        deleteNode(doublyLinkedListDS.head, doublyLinkedListDS.head.nextNode.nextNode);

        eachNode = doublyLinkedListDS.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();
    }
}
