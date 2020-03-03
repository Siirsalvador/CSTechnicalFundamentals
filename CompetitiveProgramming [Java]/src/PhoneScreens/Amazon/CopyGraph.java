package PhoneScreens.Amazon;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-12
 */
public class CopyGraph {
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        HashMap<Node, Node> oldToNewNodes = new HashMap<>();

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();
            Node newCurr = new Node(curr.val, new ArrayList<>());

            oldToNewNodes.put(curr, newCurr);

            for (Node adj : curr.neighbors) {
                if (!oldToNewNodes.containsKey(adj)) {
                    nodeQueue.offer(adj);
                }
            }
        }

        for (Map.Entry<Node, Node> entry : oldToNewNodes.entrySet()) {
            Node oldNode = entry.getKey();
            List<Node> oldAdjs = oldNode.neighbors;

            Node newNode = entry.getValue();
            for (Node adj : oldAdjs) {
                newNode.neighbors.
                        add(oldToNewNodes.get(adj));
            }
        }

        return oldToNewNodes.get(node);
    }

    public Node cloneGraph2(Node node) {

        if (node == null) return null;

        HashMap<Node, Node> oldToNewNodes = new HashMap<>();

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        Node newCurr = new Node(node.val, new ArrayList<>());
        oldToNewNodes.put(node, newCurr);

        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();

            for (Node adj : curr.neighbors) {
                if (!oldToNewNodes.containsKey(adj)) {
                    oldToNewNodes.put(adj, new Node(adj.val, new ArrayList<>()));
                    nodeQueue.offer(adj);
                }

                oldToNewNodes.get(curr).neighbors.add(
                        oldToNewNodes.get(adj));
            }
        }

        return oldToNewNodes.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    ;
}
