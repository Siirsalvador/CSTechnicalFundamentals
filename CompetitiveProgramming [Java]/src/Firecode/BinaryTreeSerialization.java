package Firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-29
 */
public class BinaryTreeSerialization {

    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public String serializeTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<String> arr = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                arr.add("*");
                continue;
            } else arr.add(String.valueOf(curr.data));

            queue.add(curr.left);
            queue.add(curr.right);
        }

        return arr.toString();
    }

    public TreeNode restoreTree(String str) {
        if (str == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        int len = str.length();
        String subStr = str.substring(1, len - 1);
        for (int i = 0; i < subStr.length(); i++) {
            char curr = subStr.charAt(i);
            if (curr == ',' || curr == ' ') continue;
            if (curr == '*') queue.add(null);
            else queue.add(new TreeNode(Integer.parseInt(String.valueOf(curr))));
        }

        TreeNode root = queue.poll();
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);

        while (!queue.isEmpty() && !level.isEmpty()) {
            TreeNode curr = level.poll();
            if (curr == null) continue;

            curr.left = queue.poll();
            curr.right = queue.poll();

            level.add(curr.left);
            level.add(curr.right);
        }

        return root;
    }
}
