package Firecode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class FindKLargestNodeInBST {

    //Recursive - reverseInorder
    public static TreeNode findKthLargest(TreeNode root, int k) {
        int[] count = new int[1];
        TreeNode[] kthLargest = new TreeNode[1];
        findKthLargestUtil(root, k, count, kthLargest);
        return kthLargest[0];
    }

    private static void findKthLargestUtil(TreeNode root, int k, int[] count, TreeNode[] kthLargest) {

        if (root == null || count[0] >= k) return;

        findKthLargestUtil(root.right, k, count, kthLargest);

        System.out.println("Current root: " + root.data);
        System.out.println("Incremented count");

        count[0]++;
        if (count[0] == k) kthLargest[0] = root;

        findKthLargestUtil(root.left, k, count, kthLargest);
    }

    //Iterative
    private static TreeNode findKthLargestItr(TreeNode root, int k) {

        TreeNode kthLargest = null;
        Stack<TreeNode> nodeStack = new Stack<>();
        int count = 0;

        while (true) {
            while (root != null) {
                nodeStack.add(root);
                root = root.right;
            }

            if (nodeStack.isEmpty()) break;
            root = nodeStack.pop();
            count++;
            if (count == k) {
                kthLargest = root;
                break;
            }
            root = root.left;

        }
        return kthLargest;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        TreeNode kthLargest = findKthLargestItr(root, 4);
        System.out.println(kthLargest.data);
    }
}
