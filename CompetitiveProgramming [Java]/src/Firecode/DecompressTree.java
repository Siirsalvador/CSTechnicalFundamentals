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

    public static TreeNode decompressTree(String[] nodes, int index) {
        if (index >= nodes.length) return null;
        if (nodes[index].equals("*")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index]));
        root.left = decompressTree(nodes, index * 2 + 1);
        root.right = decompressTree(nodes, index * 2 + 2);

        return root;
    }

    public static TreeNode decompressTreeHeap(String str) {
        return decompressTree(str.split(","), 0);
    }

    public static void main(String[] args) {
        String testStr = "1,2,3,4,5,6,7,*,*,2,*,1,*,1,*";
        System.out.println(decompressTree(testStr));
    }
}