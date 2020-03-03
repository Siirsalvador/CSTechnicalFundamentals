package Pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-04
 */
public class FindDuplicates {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here
        if (arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        ArrayList<Integer> result = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < arr1.length && idx2 < arr2.length) {
            if (arr1[idx1] == arr2[idx2]) {
                result.add(arr1[idx1]);
                idx1++;
                idx2++;
                continue;
            }

            if (arr1[idx1] < arr2[idx2]) {
                idx1++;
                continue;
            }

            if (arr1[idx1] > arr2[idx2]) {
                idx2++;
            }
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }

        return resArr;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8, 20};


        System.out.println(Arrays.toString(findDuplicates(arr1, arr2)));
    }
}
