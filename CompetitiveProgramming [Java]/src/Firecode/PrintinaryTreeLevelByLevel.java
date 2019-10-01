package Firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-10
 */
public class PrintinaryTreeLevelByLevel {
    public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> allNodes = new ArrayList<>();
        ArrayList<Integer> nodesAtLvl = new ArrayList<>();

        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            TreeNode curr = currentLevel.poll();

            nodesAtLvl.add(curr.data);
            if (curr.left != null) nextLevel.add(curr.left);
            if (curr.right != null) nextLevel.add(curr.right);

            if (currentLevel.isEmpty()) {
                allNodes.add(nodesAtLvl);
                nodesAtLvl = new ArrayList<>();
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }
        }

        return allNodes;
    }

    public ArrayList<ArrayList<Integer>> printLevelByLevelEff(TreeNode root) {
        ArrayList<ArrayList<Integer>> allNodes = new ArrayList<>();
        if (root == null) return allNodes;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            ArrayList<Integer> aLevel = new ArrayList<>();
            int size = nodeQueue.size();

            while (size-- > 0) {
                TreeNode curr = nodeQueue.poll();
                aLevel.add(curr.data);

                if (curr.left != null) nodeQueue.add(curr.left);
                if (curr.right != null) nodeQueue.add(curr.right);
            }

            allNodes.add(aLevel);
        }

        return allNodes;
    }


}
