package Firecode.KthLargestNodeInBST;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class GFGKLargestNode {
}

// Java code to find k'th largest element in BST

// A binary tree node
class Node {

    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class BinarySearchTree {

    // Root of BST
    private Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // class that stores the value of count
    public class count {
        int c = 0;
    }

    // Method to find the kth largest no in given BST
    void kthLargest(int k)
    {
        count c = new count(); // object of class count
        this.kthLargestUtil(this.root, k, c);
    }

    // utility function to find kth largest no in
    // a given tree
    private void kthLargestUtil(Node node, int k, count C)
    {

        if (node == null || C.c >= k)
            return;

        this.kthLargestUtil(node.right, k, C);

        C.c++;

        // If c becomes k now, then this is the k'th largest
        if (C.c == k) {
            System.out.println(k + "th largest element is " +
                    node.data);
            return;
        }

        // Recur for left subtree
        this.kthLargestUtil(node.left, k, C);
    }



}
