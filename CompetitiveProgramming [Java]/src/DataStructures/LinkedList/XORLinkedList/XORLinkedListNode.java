package DataStructures.LinkedList.XORLinkedList;

public class XORLinkedListNode {
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
