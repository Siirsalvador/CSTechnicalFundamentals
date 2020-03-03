package PhoneScreens.Facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-27
 */
public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {

        if (root == null) return true;

        /*
        Use a queue
        left is null, add null

        */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean emptyFound = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                emptyFound = true;
                continue;
            }

            if (curr != null && emptyFound) return false;

            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return true;
    }

}
