package Firecode.BSTDiameter;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-04
 */

// A utility class to pass height object
class Height {
    int h;
}

/* Class to print the Diameter */
class GFGBSTDiameterOpt {
    private Node root;

    public static void main(String[] args) {

        GFGBSTDiameterOpt tree = new GFGBSTDiameterOpt();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("The diameter of given binary tree is : "
                + tree.diameter());
    }


    private int diameterOpt(Node root, Height height) {

        Height lh = new Height(), rh = new Height();

        if (root == null) {
            height.h = 0;
            return 0;
        }

        /* Get the heights of left and right subtrees in lh and rh
         And store the returned values in ldiameter and ldiameter */
        int ldiameter = diameterOpt(root.left, lh);
        int rdiameter = diameterOpt(root.right, rh);

        /* Height of current node is max of heights of left and
         right subtrees plus 1*/
        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }

    /* A wrapper over diameter(Node root) */
    private int diameter() {
        Height height = new Height();
        return diameterOpt(root, height);
    }
}