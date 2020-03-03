package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-02
 */
public class BinaryTreePreorderTraversal {

    //Preorder: data, right, left
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr != null) {
                result.add(curr.val);
                stack.add(curr.right);
                stack.add(curr.left);
            }
        }

        return result;
    }
}
