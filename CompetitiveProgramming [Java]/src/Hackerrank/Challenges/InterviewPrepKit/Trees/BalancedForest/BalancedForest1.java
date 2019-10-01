package Hackerrank.Challenges.InterviewPrepKit.Trees.BalancedForest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-28
 */
public class BalancedForest1 {

    private static final Scanner scanner = new Scanner(System.in);
    private static int minVal = Integer.MAX_VALUE;

    // Complete the balancedForest function below.
    private static int balancedForest(int[] c, int[][] edges) throws Exception {

        //Edge Cases
        if (edges.length == 0)
            return -1;

        /**
         * Make all nodes that 1 connects to as key
         * Every node connected to them should be added a value in a map
         */
        HashMap<Integer, Integer> nodesToSum = new HashMap<>();

        for (int[] anEdge : edges) {

            int node1 = anEdge[0];
            int node2 = anEdge[1];

            if (nodesToSum.containsKey(node1)) {
                nodesToSum.put(node2, nodesToSum.get(node1) + c[node2 - 1]);
                nodesToSum.remove(node1);
            } else {
                nodesToSum.put(node2, c[node1 - 1] + c[node2 - 1]);
            }
        }

        if (nodesToSum.keySet().size() < 3) {
            int maxKey = Integer.MIN_VALUE;
            for (Integer key : nodesToSum.keySet()) {
                if (key > maxKey) {
                    maxKey = key;
                }
            }

            nodesToSum.put(maxKey + 1, c[0]);
        }

        //Find Min Val
        if (nodesToSum.keySet().size() == 3) {
            findMinVal(nodesToSum, c[0]);
        } else {
            minVal = -1;
        }

        return minVal;
    }

    private static void findMinVal(HashMap<Integer, Integer> nodesToSum, int rootVal) {

        ArrayList<Integer> keyList = new ArrayList<>(nodesToSum.keySet());

        for (int i = 0; i < keyList.size(); i++) {

            if (i == 0) {

                findAllMinimums(nodesToSum.get(keyList.get(0)) - rootVal, nodesToSum.get(keyList.get(1)), nodesToSum.get(keyList.get(2)));

            } else if (i == 1) {

                findAllMinimums(nodesToSum.get(keyList.get(0)), nodesToSum.get(keyList.get(1))- rootVal, nodesToSum.get(keyList.get(2)));

            } else if (i == 2) {

                findAllMinimums(nodesToSum.get(keyList.get(0)), nodesToSum.get(keyList.get(1)), nodesToSum.get(keyList.get(2))- rootVal);

            }
        }
    }

    private static void findAllMinimums(Integer integer, Integer integer1, Integer integer2) {

        int min = Integer.MAX_VALUE;
        int possibleMin;


        if (integer.equals(integer1)) {
            min = integer - integer2;
        }

        if (integer.equals(integer2)) {
            possibleMin = integer - integer1;
            if (possibleMin < min) {
                min = possibleMin;
            }
        }

        if (integer1.equals(integer2)) {
            possibleMin = integer1 - integer;
            if (possibleMin < min) {
                min = possibleMin;
            }
        }

        if (min < minVal && min >= 0)
            minVal = min;

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
