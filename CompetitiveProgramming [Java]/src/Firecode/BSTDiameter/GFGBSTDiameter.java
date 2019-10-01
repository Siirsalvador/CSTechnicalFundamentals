package Firecode.BSTDiameter;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-04
 */

// Recursive optimized Java program to find the diameter of a
// Binary Tree

/* Class containing left and right child of current
 node and key value*/
class Node {
    Node left, right;
    private int data;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

/* Class to print the Diameter */
class GFGBSTDiameter {
    private Node root;

    private static int height(Node node) {
        /* base case tree is empty */
        if (node == null)
            return 0;

        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        GFGBSTDiameter tree = new GFGBSTDiameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + tree.diameter());
    }

    /* Method to calculate the diameter and return it to main */
    private int diameter(Node root) {
        /* base case if tree is empty */
        if (root == null)
            return 0;

        /* get the height of left and right sub trees */
        int lheight = height(root.left);
        int rheight = height(root.right);

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));

    }

    /* A wrapper over diameter(Node root) */
    private int diameter() {
        return diameter(root);
    }
}
