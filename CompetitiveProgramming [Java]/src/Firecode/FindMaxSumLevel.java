package Firecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-04
 */
public class FindMaxSumLevel {

    public int findMaxSumLevel(TreeNode root) {
        if(root == null) return -1;

        //Use Queue 1 to store current level
        //Use Queue 2 to store next level. if Queue 1 is empty, Queue 2 = Queue 1

        Queue<TreeNode> curr = new LinkedList<>();
        curr.add(root);

        Queue<TreeNode> next = new LinkedList<>();

        int[] max = new int[2];
        int aMax = 0;

        int level = 0;

        while(!curr.isEmpty()){
            TreeNode current = curr.poll();
            aMax += current.data;

            if(current.left != null) next.add(current.left);
            if(current.right != null) next.add(current.right);

            if(curr.isEmpty()){
                if(aMax > max[0]){
                    max[0] = aMax;
                    max[1] = level;
                }
                level++;
                aMax = 0;
                curr = next;
                next = new LinkedList<>();
            }
        }

        return max[1];
    }

    public int findMaxSumLevel2(TreeNode root) {
        if(root==null) return -1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int maxSum = root.data;
        int count = 0, maxCount = 0;
        while(!q.isEmpty()){
            int sum = 0;
            int total = q.size();
            for(int i = 0; i < total; i++){
                TreeNode curr = q.remove();
                sum += curr.data;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                maxCount = count;
            }
            count++;
        }
        return maxCount;
    }

}
