package Firecode;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-27
 */
public class TreePreorderItr {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(10);

        System.out.println(preorderItr2(root));
    }

    private static ArrayList<Integer> preorderItr2(TreeNode root) {

        if (root == null) return new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr != null) {
                list.add(curr.data);
                st.add(curr.right);
                st.add(curr.left);
            }

        }

        return list;
    }

    public static ArrayList<Integer> preorderItr(TreeNode root) {
        ArrayList<Integer> preorderedList = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        if (root == null) {
            return preorderedList;
        }

        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            preorderedList.add(root.data);
            if (root.right != null) {
                s.push(root.right);
            }
            if (root.left != null) {
                s.push(root.left);
            }
        }

        return preorderedList;
    }

}
