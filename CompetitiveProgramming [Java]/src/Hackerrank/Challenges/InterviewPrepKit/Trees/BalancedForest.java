package Hackerrank.Challenges.InterviewPrepKit.Trees;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-07-28
 */
public class BalancedForest {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the balancedForest function below.
    private static int balancedForest(int[] c, int[][] edges) throws Exception {

        //Edge Cases
        if (c.length < 4 || edges.length == 0)
            return -1;

        /**
         *
         * Seperate Concerns:
         *
         * Get all the sums for every subtree (edge to root):
         * if first letter is a one, add the last letter to a map as key, and data as value
         * if not find first letter in map, replace with last number and update the value
         */
        HashMap<Integer, Integer> subTreeToVal = new HashMap<>();

        for (int[] edge : edges) {

            int firstNode = edge[0];
            int secondNode = edge[1];

            if (firstNode == 1) {

                subTreeToVal.put(secondNode, c[firstNode - 1] + c[secondNode - 1]);

            } else {

                Integer currSum = subTreeToVal.get(firstNode);

                if (currSum == null) {
                    //throw new Exception("Illegal Tree");
                    return -1;
                }

                currSum += c[secondNode - 1];
                subTreeToVal.remove(firstNode);

                subTreeToVal.put(secondNode, currSum);
            }
        }

        /**
         * foundMin = false;
         * while(!foundMin)
         * if map > 3 or < 3, cannot form.
         *
         * value 1, value 2, value 3
         *
         * if (value 1 - edge connected to 1 == value 2)
         *  value 2 - (value 3 - 1)
         *
         * if (value 1 - edge connected to 1 == value 3)
         *
         * if (value 2 - edge connected to 1 == value 1)
         *
         * if (value 2 - edge connected to 1 == value 3)
         *
         * if (value 3 - edge connected to 1 == value 1)
         *
         * if (value 3 - edge connected to 1 == value 2)
         *
         */

        if (subTreeToVal.size() != 3) {
            //throw new Exception("Illegal Tree");
            return -1;
        }

        Object[] mapKeys = subTreeToVal.keySet().toArray();
        Integer val1 = (Integer) mapKeys[0];
        Integer val2 = (Integer) mapKeys[1];
        Integer val3 = (Integer) mapKeys[2];

        if ((subTreeToVal.get(val1) - c[0]) == subTreeToVal.get(val2) && subTreeToVal.get(val2) > subTreeToVal.get(val3))
            return subTreeToVal.get(val2) - (subTreeToVal.get(val3) - c[0]);

        if ((subTreeToVal.get(val1) - c[0]) == subTreeToVal.get(val3) && subTreeToVal.get(val3) > subTreeToVal.get(val2))
            return subTreeToVal.get(val3) - (subTreeToVal.get(val2) - c[0]);

        if ((subTreeToVal.get(val2) - c[0]) == subTreeToVal.get(val1) && subTreeToVal.get(val1) > subTreeToVal.get(val3))
            return subTreeToVal.get(val1) - (subTreeToVal.get(val3) - c[0]);

        if ((subTreeToVal.get(val2) - c[0]) == subTreeToVal.get(val3) && subTreeToVal.get(val3) > subTreeToVal.get(val1))
            return subTreeToVal.get(val3) - (subTreeToVal.get(val1) - c[0]);

        if ((subTreeToVal.get(val3) - c[0]) == subTreeToVal.get(val1) && subTreeToVal.get(val1) > subTreeToVal.get(val2))
            return subTreeToVal.get(val1) - (subTreeToVal.get(val2) - c[0]);

        if ((subTreeToVal.get(val3) - c[0]) == subTreeToVal.get(val2) && subTreeToVal.get(val2) > subTreeToVal.get(val1))
            return subTreeToVal.get(val2) - (subTreeToVal.get(val1) - c[0]);

        return -1;
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
