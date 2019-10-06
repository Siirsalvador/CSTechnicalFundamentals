package Firecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-23
 */
public class DecompressTree {

    //add to stack
    //root = pop

    //Queue, enqueue root

    //curr = poll
    //curr.left == pop
    //curr.right == pop

    //enqueue left
    //enqueue right


    //return root

    public static TreeNode decompressTree(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '*') return null;
        String[] eachStr = str.split(",");
        //Queue1 (add all Strings)
        //root = poll Queue1

        //Queue2
        //enqueue root

        //curr = dequeue Queue2
        //curr.left = dequeue Q1
        //curr.right = dequeue Q1

        //enqueue Queue2 (l & r)
        Queue<TreeNode> queue1 = new LinkedList<>();
        for (String aStr : eachStr) {
            if (aStr.equals("*")) aStr = null;
            TreeNode curr = aStr == null ? null : new TreeNode(Integer.parseInt(aStr));
            queue1.add(curr);
        }

        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode root = queue1.poll();
        queue2.add(root);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode curr = queue2.poll();
            if (curr == null) continue;

            curr.left = queue1.poll();
            curr.right = queue1.poll();

            queue2.add(curr.left);
            queue2.add(curr.right);
        }

        return root;
    }

    public static TreeNode decompressTreeAttempt2(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '*') return null;

        String[] strArr = str.split(",");

        Queue<TreeNode> allNodes = new LinkedList<>();
        for (String aStr : strArr) {
            if (aStr.equals("*")) allNodes.add(null);
            else allNodes.add(new TreeNode(Integer.parseInt(aStr)));
        }

        Queue<TreeNode> currLevel = new LinkedList<>();
        TreeNode root = allNodes.poll();
        currLevel.add(root);

        while (!allNodes.isEmpty()) {
            TreeNode curr = currLevel.poll();
            if (curr == null) continue;

            curr.left = allNodes.poll();
            curr.right = allNodes.poll();

            currLevel.add(curr.left);
            currLevel.add(curr.right);
        }

        return root;
    }

    public static void main(String[] args) {
        String testStr = "1,2,3,4,5,6,7,*,*,2,*,1,*,1,*";
        System.out.println(decompressTree(testStr));
    }
}