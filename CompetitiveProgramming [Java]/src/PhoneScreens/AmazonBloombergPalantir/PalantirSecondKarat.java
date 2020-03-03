package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-31
 */
public class PalantirSecondKarat {

    /*


Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, the earliest ancestor of 6 is 14, and the earliest ancestor of 15 is 2.

         14
         |
  2      4
  |    / | \
  3   5  8  9
 / \ / \     \
15  6   7    11

Write a function that, for a given individual in our dataset, returns their earliest known ancestor -- the one at the farthest distance from the input individual. If there is more than one ancestor tied for "earliest", return any one of them. If the input individual has no parents, the function should return null (or -1).

Sample input and output:

parentChildPairs3 = [
    (2, 3), (3, 15), (3, 6), (5, 6), (5, 7),
    (4, 5), (4, 8), (4, 9), (9, 11), (14, 4),
]

int maxLevel = -1;
int earliestAncestor = -1;

Stack
// 8: 4
// Node: val = 8, ; level = 0


//Node: val = 4, level = 1;
if(node.val > maxLevel){
  maxlevel = node.level;
  earliestAncestor = node.val;
}


findEarliestAncestor(parentChildPairs3, 8) => 14
findEarliestAncestor(parentChildPairs3, 7) => 14
findEarliestAncestor(parentChildPairs3, 6) => 14
findEarliestAncestor(parentChildPairs3, 15) => 2
findEarliestAncestor(parentChildPairs3, 14) => null or -1

Additional example:

  14
  |
  2      4
  |    / | \
  3   5  8  9
 / \ / \     \
15  6   7    11

parentChildPairs4 = [
    (2, 3), (3, 15), (3, 6), (5, 6), (5, 7),
    (4, 5), (4, 8), (4, 9), (9, 11), (14, 2),
]

findEarliestAncestor(parentChildPairs4, 8) => 4
findEarliestAncestor(parentChildPairs4, 7) => 4
findEarliestAncestor(parentChildPairs4, 6) => 14
findEarliestAncestor(parentChildPairs4, 15) => 14
findEarliestAncestor(parentChildPairs4, 14) => null or -1

n: number of pairs in the input


*/

    public static void main(String[] argv) {

        int[][] parentChildPairs3 = new int[][]{
                {2, 3}, {3, 15}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 4}
        };

        int[][] parentChildPairs4 = new int[][]{
                {2, 3}, {3, 15}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}, {14, 2}
        };


        int[][] parentChildPairs1 = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}
        };

        int[][] parentChildPairs2 = new int[][]{
                {11, 10}, {11, 12}, {10, 2}, {10, 5}, {1, 3},
                {2, 3}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };

        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };

        //System.out.println(evaluatePairs(parentChildPairs));
        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9));
        System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3));
        System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6));

        System.out.println(hasCommonAncestor(parentChildPairs2, 4, 12));
        System.out.println(hasCommonAncestor(parentChildPairs2, 1, 6));
        System.out.println(hasCommonAncestor(parentChildPairs2, 1, 12));

    }

    public static boolean hasCommonAncestor(int[][] pairs, int node1, int node2) {
        if (pairs == null || pairs.length == 0) return false;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[1]).add(pair[0]);
        }

        Set<Integer> node1Set = new HashSet<>();
        Stack<Integer> node1Stack = new Stack<>();
        node1Stack.add(node1);

        while (!node1Stack.isEmpty()) {
            Integer curr = node1Stack.pop();

            if (curr != node1) node1Set.add(curr);

            if (map.containsKey(curr)) {
                ArrayList<Integer> parents = map.get(curr);
                for (Integer parent : parents) {
                    node1Stack.add(parent);
                }
            }
        }


        Stack<Integer> node2Stack = new Stack<>();
        node2Stack.add(node2);
        while (!node2Stack.isEmpty()) {
            Integer curr = node2Stack.pop();

            if (curr != node2 && node1Set.contains(curr)) return true;

            if (map.containsKey(curr)) {
                ArrayList<Integer> parents = map.get(curr);
                for (Integer parent : parents) {
                    node2Stack.add(parent);
                }
            }
        }

        return false;
    }

    public static ArrayList<ArrayList<Integer>> evaluatePairs(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return new ArrayList<>();

        HashMap<Integer, Integer> childToParent = new HashMap<>();
        for (int[] pair : pairs) {
            childToParent.putIfAbsent(pair[0], 0);
            childToParent.putIfAbsent(pair[1], 0);
            childToParent.put(pair[1], childToParent.get(pair[1]) + 1);
        }

        ArrayList<Integer> zeroParents = new ArrayList<>();
        ArrayList<Integer> oneParent = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : childToParent.entrySet()) {
            if (entry.getValue() == 0) {
                zeroParents.add(entry.getKey());
                continue;
            }

            if (entry.getValue() == 1) {
                oneParent.add(entry.getKey());
            }
        }


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(zeroParents);
        result.add(oneParent);

        return result;
    }
}