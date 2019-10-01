package Firecode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class KthSmallestNodeinBST {

    public TreeNode findKthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        TreeNode[] kthSmall = new TreeNode[1];
        findKthSmallestUtil(root, k, count, kthSmall);
        return kthSmall[0];
    }

    public void findKthSmallestUtil(TreeNode root, int k, int[] count, TreeNode[] kthSmallest) {
        if (root == null) return;

        findKthSmallestUtil(root.left, k, count, kthSmallest);

        count[0]++;
        if (count[0] == k) kthSmallest[0] = root;

        findKthSmallestUtil(root.right, k, count, kthSmallest);
    }

    //Iterative
    public TreeNode findKthSmallestItr(TreeNode root, int k) {

        if (root == null) return null;

        Stack<TreeNode> nodeStack = new Stack<>();
        int count = 0;

        while (true) {
            while (root != null) {
                nodeStack.add(root);
                root = root.left;
            }

            if (nodeStack.isEmpty()) break;

            root = nodeStack.pop();
            count++;
            if (count == k) return root;

            root = root.left;
        }

        return null;
    }
}
