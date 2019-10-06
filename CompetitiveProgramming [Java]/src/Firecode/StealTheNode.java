package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-05
 */
public class StealTheNode {

    public static TreeNode delete(TreeNode root, int data) {
        if (root == null) return null;

        if (root.data == data) {

            if (root.left == null && root.right == null) return null;
            if (root.left != null && root.right != null) {

                int temp = root.right.data;
                root.right.data = root.data;
                root.data = temp;

                return delete(root, data);
            }

            return root.left == null ? root.right : root.left;
        }

        root.left = delete(root.left, data);
        root.right = delete(root.right, data);

        return root;
    }

    public static void main(String[] arg) {

    }
}
