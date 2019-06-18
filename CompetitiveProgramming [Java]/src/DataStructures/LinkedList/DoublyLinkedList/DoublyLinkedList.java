package DataStructures.LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    private DoublyLinkedListNode head;

    private static void push(DoublyLinkedList doublyLinkedList, int data) {

        DoublyLinkedListNode headNode = doublyLinkedList.head;
        if (headNode == null) {
            doublyLinkedList.head = new DoublyLinkedListNode(data);
            doublyLinkedList.head.nextNode = null;
            doublyLinkedList.head.previousNode = null;
            return;
        }

        headNode = doublyLinkedList.head;

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        headNode.previousNode = newNode;
        newNode.nextNode = headNode;
        doublyLinkedList.head = newNode;
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

    private static void append(DoublyLinkedList doublyLinkedList, int data) {
        DoublyLinkedListNode headNode = doublyLinkedList.head;
        if (headNode == null) {
            doublyLinkedList.head = new DoublyLinkedListNode(data);
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
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.head = new DoublyLinkedListNode(10);

        DoublyLinkedListNode eachNode = doublyLinkedList.head;
        while (eachNode != null) {
            System.out.println(eachNode.data);
            eachNode = eachNode.nextNode;
        }

        push(doublyLinkedList, 12);

        eachNode = doublyLinkedList.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();

        insertAfter(doublyLinkedList.head.nextNode, 25);

        eachNode = doublyLinkedList.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();

        append(doublyLinkedList, 3500);

        eachNode = doublyLinkedList.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();

        deleteNode(doublyLinkedList.head, doublyLinkedList.head.nextNode.nextNode);

        eachNode = doublyLinkedList.head;
        while (eachNode != null) {
            System.out.print(eachNode.data + " ");
            eachNode = eachNode.nextNode;
        }
        System.out.println();
    }
}

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode nextNode;
    DoublyLinkedListNode previousNode;

    DoublyLinkedListNode(int d) {
        data = d;
    }
}

