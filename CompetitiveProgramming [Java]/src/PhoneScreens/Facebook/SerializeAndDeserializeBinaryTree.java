package PhoneScreens.Facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-11
 */
public class SerializeAndDeserializeBinaryTree {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();
            if (sb.length() > 0) sb.append(",");

            if (curr == null) {
                sb.append("*");
                continue;
            }

            sb.append(curr.val);
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data == null || data.isEmpty()) return null;

        String[] stringArr = data.split(",");

        TreeNode head = new TreeNode(Integer.valueOf(stringArr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) continue;

            TreeNode left = stringArr[i].equals("*") ? null : new TreeNode(Integer.valueOf(stringArr[i]));
            i++;
            TreeNode right = stringArr[i].equals("*") ? null : new TreeNode(Integer.valueOf(stringArr[i]));
            i++;

            curr.left = left;
            curr.right = right;

            queue.offer(left);
            queue.offer(right);
        }

        return head;
    }
}