package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-27
 */
public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalOrder(TreeNode root) {
            /*
            Traverse the whole tree, visit each element and get its position
            Then sort according to x, y and val
            Then output.
         */
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0, 0, 0, root));

        int pos = 1;
        List<Location> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Location curr = queue.poll();
            list.add(curr);

            TreeNode tn = curr.node;
            if (tn.left != null)
                queue.offer(new Location(curr.x - 1, curr.y - 1, pos++, tn.left));

            if (tn.right != null)
                queue.offer(new Location(curr.x + 1, curr.y - 1, pos++, tn.right));

        }


        Collections.sort(list);

        List<Integer> tmp = new ArrayList<>();
        tmp.add(list.get(0).node.val);
        int prev_x = list.get(0).x;

        int idx = 1;
        boolean found = false;

        while (idx < list.size()) {
            found = true;
            Location curr = list.get(idx);
            if (curr.x == prev_x) {
                tmp.add(list.get(idx).node.val);
            } else {
                res.add(tmp);
                tmp = new ArrayList<>();
                prev_x = list.get(idx).x;
                tmp.add(list.get(idx).node.val);
            }

            if (idx + 1 == list.size()) {
                res.add(tmp);
            }

            idx++;
        }

        if (!found) res.add(tmp);

        return res;
    }
}

class Location implements Comparable<Location> {
    int x;
    int y;
    int pos;
    TreeNode node;

    Location(int x, int y, int pos, TreeNode node) {
        this.x = x;
        this.y = y;
        this.pos = pos;
        this.node = node;
    }

    public int compareTo(Location o) {
        int compare = this.x - o.x;
        if (compare == 0) compare = o.y - this.y;
        if (compare == 0) compare = this.pos - o.pos;
        return compare;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


