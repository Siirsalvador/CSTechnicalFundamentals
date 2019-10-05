package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-04
 */
public class MinSumPathInTriangle {

    public static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
        //For each node, add to right and add to left
        //when we get to max rows, we bounce

        int[] buffer = new int[input.size()];

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = input.get(input.size() - 1).get(i);
        }


        return -1;
    }

}
