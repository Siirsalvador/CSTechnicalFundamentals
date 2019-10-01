package Firecode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-12
 */
public class KthLargestElement {

    public TreeNode findKthLargest(TreeNode root, int k) {
        if (root == null) return null;
        int rightSize = 0;
        if (root.right != null) {
            rightSize = size(root.right);
        }
        if (rightSize + 1 == k) {
            return root;
        } else if (k <= rightSize) {
            return findKthLargest(root.right, k);
        } else {
            return findKthLargest(root.left, k - rightSize - 1);
        }
    }

    public int size(TreeNode root) {
        int count = 0;

        if (root == null) return 0;

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            count++;

            if (curr.left != null) nodeStack.add(curr.left);
            if (curr.right != null) nodeStack.add(curr.right);
        }

        return count;
    }

}
