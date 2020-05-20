package Leetcode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-21
 */
public class ConstructBSTFromPreorderII {

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        TreeNode r = bstFromPreorder2(arr);
        System.out.println(r.val);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TNWrapper> stack = new Stack<>();
        stack.add(new TNWrapper(root, Integer.MAX_VALUE, Integer.MIN_VALUE));

        int idx = 1;
        while (!stack.isEmpty() && idx < preorder.length) {
            TNWrapper wrapper = stack.peek();
            TreeNode curr = wrapper.curr;
            int right = wrapper.right;
            int left = wrapper.left;

            int val = preorder[idx];
            TreeNode newNode = new TreeNode(val);
            TNWrapper newWrapper = new TNWrapper();

            //Insert on left side ?
            if (val > left && val < curr.val) {
                curr.left = newNode;
                newWrapper.left = left;
                newWrapper.right = curr.val;

                //Insert on right side ?
            } else if (val > curr.val && val < right) {
                curr.right = newNode;

                newWrapper.left = curr.val;
                newWrapper.right = right;

            } else {
                stack.pop();
                continue;
            }

            if (curr.right != null && curr.left != null)
                stack.pop();

            newWrapper.curr = newNode;
            stack.push(newWrapper);
        }

        return root;
    }

    public static TreeNode bstFromPreorder2(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        constructBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 1, preorder);
        return root;
    }

    private static int constructBST(TreeNode node, int minValue, int maxValue, int index, int[] preorder) {
        if (index >= preorder.length)
            return index;

        int val = preorder[index];
        if (val > minValue && val < node.val) {
            node.left = new TreeNode(val);
            index++;
            index = constructBST(node.left, minValue, node.val, index, preorder);
        }

        if (index >= preorder.length)
            return index;

        val = preorder[index];
        if (val > node.val && val < maxValue) {
            node.right = new TreeNode(preorder[index]);
            index++;
            index = constructBST(node.right, node.val, maxValue, index, preorder);
        }

        return index;
    }

}

// TreeNode Wrapper
class TNWrapper {
    TreeNode curr;
    int right;
    int left;

    TNWrapper() {
    }

    TNWrapper(TreeNode curr, int right, int left) {
        this.curr = curr;
        this.right = right;
        this.left = left;
    }
}
