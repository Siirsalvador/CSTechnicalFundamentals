package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-26
 */
public class PrampPracticeForPalantir {
    static public void main(String[] args) {
        System.out.println("Practice makes Perfect!");

        int[][] pairs = new int[][]{{1, 3}, {1, 2}, {3, 5}, {5, 6}, {4, 6}, {4, 7}};
        System.out.println(evaluateParentChildPairs(pairs));
        System.out.println("------------------");

        System.out.println(haveCommonAncestors(pairs, 3, 6));
        System.out.println(haveCommonAncestors(pairs, 2, 4));
        System.out.println(haveCommonAncestors(pairs, 2, 5));
        System.out.println(haveCommonAncestors(pairs, 1, 3));

        System.out.println("------------------");
        System.out.println(getEarliestAncestor(pairs, 6));
        //(3,6) -> true
        //(2,4) -> false
        //(2,5) -> true
        //(1,3) -> false


        //Good?
    }

    /*
  1
  | \
  2  3
      \
       5   4
        \ /|
         6 7

   get earliest ancestor

  int[][] parentChildPairs = new int[][]{{1,3}, {1,2}, {3,5}, {5,6}, {4,6}, {4,7}};
  [nodesWithNoParents, nodesWithOneParent]

  node1 & node2 -> do they have a common ancestor?
  (3,6) -> true
  (2,4) -> false
  (2,5) -> true
  (1,3) -> false
  (1,2) -> false cool

 Hey, can you see this? yes


  Can you hear me? Should I type? yes please, can't hear a thing

  Re-represent pairs as an adjacency list, but instead of storing parent child relationships, I'll store child parent relationships.
  Then I'd perform a dfs on node1, using a stack to visit parents and parents of parents.
  Store every node on that path in a set

  I'd perform a dfs on node2 and if I find any intersecting nodes, I'll return true
  Else return false.

  Great! go ahead & implement. Cool?
  true or false?

  */

    public static int getEarliestAncestor(int[][] pairs, int node) {

        HashMap<Integer, List<Integer>> childToParents = new HashMap<>();
        for (int[] pair : pairs) {
            childToParents.putIfAbsent(pair[1], new ArrayList<>());
            childToParents.get(pair[1]).add(pair[0]);
        }

        int level = 0;
        int res = node;

        Stack<Node> ancestors = new Stack<>();
        Node n = new Node(node, 0);
        ancestors.add(n);

        while (!ancestors.isEmpty()) {
            Node curr = ancestors.pop();

            if (curr.level > level) {
                level = curr.level;
                res = curr.value;
            }

            if (childToParents.containsKey(curr.value)) {
                List<Integer> parents = childToParents.get(curr.value);
                for (Integer parent : parents) {
                    Node newNode = new Node();
                    newNode.value = parent;
                    newNode.level = curr.level + 1;

                    ancestors.add(newNode);
                }
            }
        }

        return res;
    }


    public static boolean haveCommonAncestors(int[][] pairs, int node1, int node2) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0)
            return false; //Confirm this. cool. or throw ex. carry on sha, time's ticking

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[1]).add(pair[0]);
        }

        Set<Integer> node1Ancestors = new HashSet<>();

        Stack<Integer> stack = new Stack<>(); //Hey can you see this? yes Please go up to the test cases
        stack.add(node1);

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            if (curr != node1) node1Ancestors.add(curr);

            if (map.containsKey(curr)) {
                List<Integer> parents = map.get(curr);
                for (int parent : parents) {
                    stack.add(parent);
                }
            }
        }

        Stack<Integer> stack2 = new Stack<>();
        stack2.add(node2);

        while (!stack2.isEmpty()) {
            int curr = stack2.pop();

            if (node1Ancestors.contains(curr) && curr != node2) return true;

            if (map.containsKey(curr)) {
                List<Integer> parents = map.get(curr);
                for (int parent : parents) {
                    stack2.add(parent);
                }
            }
        }

        return false;
    }

    //test your code
    public static List<List<Integer>> evaluateParentChildPairs(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) //O(1)
            return new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) { //O(N)
            map.putIfAbsent(pair[0], 0);
            map.putIfAbsent(pair[1], 0);
            map.put(pair[1], map.get(pair[1]) + 1);
        }

        List<Integer> noParent = new ArrayList<>();
        List<Integer> oneParent = new ArrayList<>();

        //so 1 is spelt wone in Ijebu? wawu lmaooooo i mean with one parent please..
        //carry on, i'm timing you
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { //O(N)
            if (entry.getValue() == 0) {
                noParent.add(entry.getKey());
                continue;
            }

            if (entry.getValue() == 1) {
                oneParent.add(entry.getKey());
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(noParent);
        result.add(oneParent);

        return result;//test your code okay
    }


}

class Node {
    int value;
    int level;

    Node() {
    }

    Node(int value, int level) {
        this.value = value;
        this.level = level;
    }
}