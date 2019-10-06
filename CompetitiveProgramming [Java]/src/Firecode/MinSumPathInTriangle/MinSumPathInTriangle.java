package Firecode.MinSumPathInTriangle;

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
        int n = input.size() - 1;

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = input.get(n).get(i);
        }

        for (int i = input.size() - 2; i >= 0; i--) {
            for (int j = 0; j < input.get(i).size(); j++) {
                buffer[j] = input.get(i).get(j) + Math.min(buffer[j], buffer[j + 1]);
            }
        }

        return buffer[0];
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        ArrayList<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input.add(input1);

        input1 = new ArrayList<>();
        input1.add(2);
        input1.add(3);
        input.add(input1);

        input1 = new ArrayList<>();
        input1.add(4);
        input1.add(5);
        input1.add(6);
        input.add(input1);

        System.out.println(minTriangleDepth(input));
    }

}
