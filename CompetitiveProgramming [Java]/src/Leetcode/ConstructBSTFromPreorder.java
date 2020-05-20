package Leetcode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-21
 */
public class ConstructBSTFromPreorder {

    public static void main(String[] args) {

//        TreeNode node = new TreeNode(8);
//        insertIntoBST(node, 5);
//
//        System.out.println(node);
        int[] arr = {8, 5, 1, 7, 10, 12};
        TreeNode r = bstFromPreorder(arr);
        System.out.println(r.val);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insertIntoBST(root, preorder[i]);
        }

        return root;
    }

    static TreeNode insertIntoBST(TreeNode node, int num) {
        if (node == null) {
            node = new TreeNode(num);
            return node;
        }

        if (num > node.val)
            node.right = insertIntoBST(node.right, num);
        else
            node.left = insertIntoBST(node.left, num);

        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}
