package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-04
 */

/*
    Given an array of integers and a target number, determine if it is possible to choose a group of integers from the array,
    such that the numbers in the group sum to the given target.

    Examples:
    groupSum({1,2,3,6,5},10) ==> true

    groupSum({1,2,3,6,5},18) ==> false
 */
public class SubSetSummation {

    private static boolean groupSum(int[] arr, int target) {
        if (arr.length == 0) return false;

        int endIdx = arr.length - 1;
        return groupSum(endIdx, arr, target);
    }

    private static boolean groupSum(int endIdx, int[] arr, int target) {

        if (endIdx == 0) {
            return target == 0;
        }

        return groupSum(endIdx - 1, arr, target - arr[endIdx])
                || groupSum(endIdx - 1, arr, target);
    }

    public static void main(String[] args) {
        int[] arr = {10, 3, 4, 6, 7};
        System.out.println(groupSum(arr, 7));

        int[] arr2 = {1, 2, 3, 6, 5};
        System.out.println(groupSum(arr2, 10));

        int[] arr3 = {1, 2, 3, 6, 5};
        System.out.println(groupSum(arr3, 18));
    }


}
