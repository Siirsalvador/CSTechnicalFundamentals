package Leetcode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-01
 */


import java.util.Arrays;

/*

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8

startIdx = 0
endIdx = 5
mid = 2  7

while to the left until it reaches startIdx or tar
while to the right

Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,8], target = 6
Output: [-1,-1]

nums = [4 4 4 4 4] targ=4

*/

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,8}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int arrStart = 0;
        int arrEnd = nums.length - 1;


        int startPos = -1;
        int endPos = -1;

        //Find endPos
        while(arrStart >= 0 && arrEnd < nums.length && arrStart <= arrEnd){
            int mid = (arrStart + arrEnd)/2;

            if(nums[mid] == target){
                endPos = mid;
                if(mid + 1 <= arrEnd && nums[mid + 1] == target){
                    arrStart = mid + 1;
                }else{
                    break;
                }
            }
            else if(target < nums[mid]){
                arrEnd = mid - 1;
            }else{
                arrStart = mid + 1;
            }

        }

        arrStart = 0;
        arrEnd = nums.length - 1;

        //Find startPos
        while(arrStart >= 0 && arrEnd < nums.length && arrStart <= arrEnd){
            int mid = (arrStart + arrEnd)/2;

            if(nums[mid] == target){
                startPos = mid;
                if(mid - 1 >= arrStart && nums[mid - 1] == target){
                    arrEnd = mid - 1;
                }else{
                    break;
                }
            }
            else if(target < nums[mid]){
                arrEnd = mid - 1;
            }else{
                arrStart = mid + 1;
            }

        }

        return new int[]{startPos, endPos};
    }

}
