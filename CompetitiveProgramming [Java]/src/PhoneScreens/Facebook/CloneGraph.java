package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-30
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return node;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node adj : curr.neighbors) {
                if (!map.containsKey(adj)) {
                    newNode = new Node(adj.val, new ArrayList<>());
                    map.put(adj, newNode);
                    queue.offer(adj);
                }

                Node currNew = map.get(curr);
                Node adjNew = map.get(adj);

                currNew.neighbors.add(adjNew);
            }
        }

        return map.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
