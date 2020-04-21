package Leetcode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-04-21
 */
public class ConstructBSTFromPreorderII {

    public static void main(String[] args) {

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
