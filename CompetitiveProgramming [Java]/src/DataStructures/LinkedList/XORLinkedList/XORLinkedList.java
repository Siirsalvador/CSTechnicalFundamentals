package DataStructures.LinkedList.XORLinkedList;

/**
 * Implement an XOR linked list; it has an add(element) which adds the element to the end,
 * and a get(index) which returns the node at index.
 * <p>
 * Assume you have access to get_pointer and
 * dereference_pointer functions that converts between nodes and memory addresses.
 */

/**
 * current_node = addr(previous) ^ add(next_node)
 * next_node = addr(previous_node) ^ npx(current_node) OR addr(previous_node) ^ (addr(previous_node) ^ addr(next_node))
 */

public class XORLinkedList {

    private XORLinkedListNode head;

    private static XORLinkedListNode calculateXORForCurrentNode(XORLinkedListNode previousNode, XORLinkedListNode nextNode) {
        //getNodeAddress(previousNode) + "^" + getNodeAddress(nextNode);
        return new XORLinkedListNode(previousNode, nextNode);
    }

    public static void insertNodeAtHead(XORLinkedList xorLinkedList, int data) {
        XORLinkedListNode headNode = xorLinkedList.head;

        XORLinkedListNode newHeadNode = new XORLinkedListNode(data);
        newHeadNode.npx = calculateXORForCurrentNode(null, headNode);

        if (headNode != null) {
            XORLinkedListNode nextNodeAddress = calculateXORForCurrentNode(null, headNode.npx);
            headNode.npx = calculateXORForCurrentNode(newHeadNode, nextNodeAddress);
        }

        xorLinkedList.head = newHeadNode;
    }

    public static void add(XORLinkedList xorLinkedList, int data) {
        XORLinkedListNode newLastNode = new XORLinkedListNode(data);

        if (xorLinkedList.head == null) {
            xorLinkedList.head = newLastNode;
            return;
        }

        XORLinkedListNode currentNode = xorLinkedList.head;
        //Store address of previous node
        XORLinkedListNode prevNode = null;
        XORLinkedListNode nextNode;

        while (currentNode.npx != null) {
            nextNode = calculateXORForCurrentNode(prevNode, currentNode.npx);
            prevNode = currentNode.npx;
            currentNode = nextNode;
        }

        newLastNode.npx = calculateXORForCurrentNode(currentNode.npx, null);
        assert prevNode != null;
        currentNode.npx = calculateXORForCurrentNode(prevNode.npx, newLastNode.npx);

    }

    public static int get(XORLinkedList xorLinkedList, int index) {

        XORLinkedListNode currentNode = xorLinkedList.head;
        XORLinkedListNode prevNode = null;
        XORLinkedListNode nextNode;
        int count = 0;

        while (currentNode.npx != null) {
            if (count == index) {
                return currentNode.data;
            } else {
                nextNode = calculateXORForCurrentNode(prevNode, currentNode.npx);

                prevNode = currentNode;
                currentNode = nextNode;
                count++;
            }
        }

        return -1;
    }
}

class XORLinkedListNode {
    int data;
    XORLinkedListNode npx;

    XORLinkedListNode(int data) {
        this.data = data;
    }

    XORLinkedListNode(XORLinkedListNode npx) {
        this.npx = npx;
    }

    XORLinkedListNode() {
    }

    XORLinkedListNode(XORLinkedListNode prev, XORLinkedListNode next) {
        npx = new XORLinkedListNode();
    }
}
