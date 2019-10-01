package Firecode;

import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-12
 */
public class BinaryTreeMirror {

    public TreeNode mirror(TreeNode root) {

        if (root == null) return null;
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();

            if (curr.left != null || curr.right != null) {
                TreeNode temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
            }

            if (curr.left != null) nodeStack.add(curr.left);
            if (curr.right != null) nodeStack.add(curr.right);
        }

        return root;

    }

    public TreeNode mirror2(TreeNode root) {

        if (root == null)
            return null;

        TreeNode left = root.left;
        root.left = mirror2(root.right);
        root.right = mirror2(left);
        return root;
    }


}
