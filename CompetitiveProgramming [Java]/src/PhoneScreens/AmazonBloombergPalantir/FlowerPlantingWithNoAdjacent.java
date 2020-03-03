package PhoneScreens.AmazonBloombergPalantir;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-23
 */
public class FlowerPlantingWithNoAdjacent {

    public static void main(String[] args) {
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println(Arrays.toString(gardenNoAdj(3, paths)));

    }

    // [[1,2],[2,3],[3,1]]
    public static int[] gardenNoAdj(int N, int[][] paths) {
        HashMap<Integer, HashSet<Integer>> pathMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            pathMap.put(i, new HashSet<>());
        }

        //Add all paths to map
        for (int[] path : paths) {
            pathMap.get(path[0]).add(path[1]);
            pathMap.get(path[1]).add(path[0]);
        }

        int[] res = new int[N];
        //For all points
        for (int i = 0; i < res.length; i++) {

            HashSet<Integer> colors = new HashSet<>();
            //Get all connections to this point
            HashSet<Integer> connections = pathMap.get(i + 1);

            //Get all colors of these connections from result set and add them to a color set
            for (Integer conn : connections) {
                int color = res[conn - 1];
                colors.add(color);
            }

            //Make current point's color the least possible that is not in color set
            for (int color = 4; color > 0; color--) {
                if (!colors.contains(color))
                    res[i] = color;
            }
        }

        return res;
    }
}
