package Firecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class FindNode {

    public TreeNode findNodeBFS(TreeNode root, int val) {

        //bfs (use queue)
        //dfs (use stack)
        //try both -> leggo


        if (root == null) return null;

        Queue<TreeNode> allNodesVisited = new LinkedList<>();
        allNodesVisited.add(root);

        while (!allNodesVisited.isEmpty()) {
            TreeNode currNode = allNodesVisited.poll();

            if (currNode.data == val) return currNode;
            if (currNode.left != null) allNodesVisited.add(currNode.left);
            if (currNode.right != null) allNodesVisited.add(currNode.right);
        }

        return null;

    }

    public TreeNode findNodeDFS(TreeNode root, int val) {

        if (root == null) return null;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();

            if (node.data == val) return node;
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
        }

        return null;
    }

    public int findMaxItr(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.add(root);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.pop();
            if(curr.data > max) max = curr.data;

            if(curr.left != null) nodes.add(curr.left);
            if(curr.right != null) nodes.add(curr.right);
        }

        return max;
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}