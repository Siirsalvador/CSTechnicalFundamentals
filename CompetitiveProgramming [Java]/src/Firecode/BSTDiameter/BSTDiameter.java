package Firecode.BSTDiameter;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-04
 */
public class BSTDiameter {
    private TreeNode node;
    /*
        The diameter of a tree T is the largest of the following quantities:
        * the diameter of T’s left subtree
        * the diameter of T’s right subtree
        * the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
     */
    private int diameter(TreeNode root) {

        if(root == null) return 0;
        int lHeight = findHeight(root.left);
        int rHeight = findHeight(root.right);
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);

        return Math.max(1 + lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }

    private int findHeight(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}

class TreeNode {
    private int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

