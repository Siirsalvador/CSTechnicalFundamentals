package Firecode.MaxSumPath;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-23
 */
public class MaxSumPath {
    public static int maxSumPath(TreeNode root) {
        int[] maxSumPathHolder = new int[1];
        maxSumPathUtil(root, maxSumPathHolder);
        return maxSumPathHolder[0];
    }

    private static int maxSumPathUtil(TreeNode root, int[] maxSumPathHolder) {
        if (root == null) return 0;

        int lSubTree = maxSumPathUtil(root.left, maxSumPathHolder);
        int rSubTree = maxSumPathUtil(root.right, maxSumPathHolder);

        int maxSumPath = lSubTree + rSubTree + root.data;
        maxSumPathHolder[0] = Math.max(maxSumPathHolder[0], maxSumPath);

        return Math.max(Math.max(lSubTree, rSubTree) + root.data, root.data);
    }

    public static void main(String[] args) {
        int chars = "ayom".charAt(0);
        System.out.println(chars);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}