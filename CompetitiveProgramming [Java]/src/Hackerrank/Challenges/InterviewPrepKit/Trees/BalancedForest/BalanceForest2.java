package Hackerrank.Challenges.InterviewPrepKit.Trees.BalancedForest;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-07
 */
public class BalanceForest2 {

    private static final Scanner scanner = new Scanner(System.in);


    // Complete the balancedForest function below.
    private static int balancedForest(int[] nodes, int[][] edges) throws Exception {

        if(edges.length < 2 || nodes.length < 4) return -1;

        //sum sub trees
        //check if two sums are equal - add root & remainder to last sum
        //add root to sum so it matches the max, add difference from max to last sum
        Map<Integer, Integer> childToSum = new HashMap<>();

        for(int[] edge : edges) {

            Arrays.sort(edge);

            int fromNode = edge[0];
            int newNode = edge[1];


            if(fromNode == 1) { // only captures first "generation" of children
                childToSum.put(newNode, nodes[newNode-1]);
                continue;
            }

            int currentSum = 0;

            if(childToSum.get(fromNode) != null)
                currentSum = childToSum.get(fromNode);

            childToSum.put(newNode, currentSum+nodes[newNode -1]);
            childToSum.remove(fromNode);
        }

        if(childToSum.size() == 2) {
            childToSum.put(nodes.length+1, 0);
        }

        return getRemainder(childToSum.values().toArray(new Integer[]{}), nodes[0]);
    }

    private static int getRemainder(Integer[] nodeSums, int root) {
        Arrays.sort(nodeSums);

        if(nodeSums[1] == nodeSums[2]){
            return nodeSums[2] - root - nodeSums[0];
        }

        return nodeSums[2] - nodeSums[0];
    }

    public static void main(String[] args) throws Exception {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int[][] edges = new int[n - 1][2];

            for (int i = 0; i < n - 1; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int result = balancedForest(c, edges);

            System.out.println(result);
        }

        scanner.close();
    }

}
