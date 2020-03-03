package PhoneScreens.AmazonBloombergPalantir;


import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class ValidateBST {

    //O(n)
    public static boolean validateBSTRec(TreeNode root) {
        return bstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean bstHelper(TreeNode root, int left, int right) {

        if (root == null) return true;
        if (root.data <= left || root.data >= right) return false;

        return bstHelper(root.left, left, root.data) && bstHelper(root.right, root.data, right);
    }

    //O(nlogn)
    public static boolean validateBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(list, root);

        ArrayList<Integer> list1 = new ArrayList<>(list);
        Collections.sort(list1);

        return list.equals(list1);
    }

    private static void inorder(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;

        if (root.left != null) inorder(list, root.left);
        list.add(root.data);
        if (root.right != null) inorder(list, root.right);
    }

    class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}


