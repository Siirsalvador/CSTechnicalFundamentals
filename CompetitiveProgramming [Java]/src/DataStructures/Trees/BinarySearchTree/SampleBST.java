package DataStructures.Trees.BinarySearchTree;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-20
 */
class Node {

    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data == node.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

public class SampleBST {

    public static void main(String[] args) {

        SampleBST bst = new SampleBST();
        Node node = new Node(4);
        bst.insert(node, 2);
        bst.insert(node, 3);
        bst.insert(node, 1);
        bst.insert(node, 7);
        bst.insert(node, 6);

    }

    private void insert(Node root, int value) {
        if (value <= root.data) {

            if (root.left == null) {
                root.left = new Node(value);
            } else {
                insert(root.left, value);
            }

        } else {

            if (root.right == null) {
                root.right = new Node(value);
            } else {
                insert(root.right, value);
            }

        }
    }

    private int height(Node root) {

        // Recursion:
        // Step 1:  Don't think too much
        // Step 2:  Know that every recursive function will have two sections:
        //  Base Condition
        // Recursive Section

        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.left != null) {
            leftHeight = 1 + height(root.left);
        }

        if (root.right != null) {
            rightHeight = 1 + height(root.right);
        }

        return Math.max(leftHeight, rightHeight);
    }

    private boolean contains(Node root, int value) {

        if (value == root.data) {
            return true;
        } else {
            if (value < root.data) {

                if (root.left == null) {
                    return false;
                } else {
                    return contains(root.left, value);
                }

            } else {

                if (root.right == null) {
                    return false;
                } else {
                    return contains(root.right, value);
                }

            }
        }
    }

    private void printInOrder(Node root) {
        if (root.left != null) {
            printInOrder(root.left);
        }

        System.out.println(root.data);

        if (root.right != null) {
            printInOrder(root.right);
        }
    }

    private Node lca(Node root, int v1, int v2) {

        if (v2 < v1) {
            int temp = v1;
            v1 = v2;
            v2 = temp;
        }

        /**
         * Time Complexity of O(logn)
         */
        if (v2 < root.data) {
            //left
            return lca(root.left, v1, v2);
        } else if (v1 > root.data) {
            //right
            return lca(root.right, v1, v2);
        } else {
            return root;
        }

    }

    /**
     * With a time complexity of O(n) this @code gets all the nodes that are traversed O(logn) to get to a each of the values (inclusive)
     * into a list and finds the most common node in desc to return the lca O(n), where n = size of the smaller list
     *
     * @param root Root Node reference
     * @param v1   First value
     * @param v2   Second value
     * @return an Integer representing the lca
     */
    private Integer lca2(Node root, int v1, int v2) {

        List<Integer> v1Nodes = new ArrayList<>();
        getAllNodes(v1Nodes, root, v1);

        List<Integer> v2Nodes = new ArrayList<>();
        getAllNodes(v2Nodes, root, v2);

        if (v1Nodes.size() > v2Nodes.size()) {
            List<Integer> temp = v1Nodes;
            v1Nodes = v2Nodes;
            v2Nodes = temp;
        }

        for (int i = v1Nodes.size() - 1; i >= 0; i--) {
            if (v2Nodes.contains(v1Nodes.get(i))) {
                return v1Nodes.get(i);
            }
        }

        throw new NoSuchElementException("There's no LCA");
    }

    private List<Integer> getAllNodes(List<Integer> listOfTraversedNodes, Node root, int value) {


        if (root.data == value) {
            listOfTraversedNodes.add(root.data);
            return listOfTraversedNodes;
        } else {

            listOfTraversedNodes.add(root.data);
            if (value < root.data) {
                //left

                if (root.left == null) {
                    throw new NoSuchElementException("Value does not exist in this tree");
                } else {
                    return getAllNodes(listOfTraversedNodes, root.left, value);
                }

            } else {
                //right

                if (root.right == null) {
                    throw new NoSuchElementException("Value does not exist in this tree");
                } else {
                    return getAllNodes(listOfTraversedNodes, root.right, value);
                }
            }
        }
    }

    private boolean checkBST(Node root) {

        ArrayList<Integer> nodesInOrder = new ArrayList<>();
        inorder(root, nodesInOrder);

        Set<Integer> uniqueNodes = new HashSet<>(nodesInOrder);
        ArrayList<Integer> uniqueNodeList = new ArrayList<>(uniqueNodes);
        Collections.sort(uniqueNodeList);

        return uniqueNodeList == nodesInOrder;
    }

    private void inorder(Node root, ArrayList<Integer> nodesInOrder) {

        if (root == null)
            return;

        inorder(root.left, nodesInOrder);
        nodesInOrder.add(root.data);
        inorder(root.right, nodesInOrder);
    }

}



