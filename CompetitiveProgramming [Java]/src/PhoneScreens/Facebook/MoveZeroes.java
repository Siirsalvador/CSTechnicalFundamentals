package PhoneScreens.Facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-26
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    /*
        Given an array nums, write a function to move all 0's to the end of it
        while maintaining the relative order of the non-zero elements.

        Input: [0,1,0,3,12]
        Output: [1,3,12,0,0]
     */

    public static void moveZeroes(int[] nums) {

        Queue<Integer> idxs = new LinkedList<>();
        boolean zeroFound = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroFound = true;
            if (nums[i] != 0 && zeroFound) idxs.offer(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !idxs.isEmpty()) {
                int j = idxs.poll();

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if(nums == null || nums.length == 0) return;

        int nonZeroIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nonZeroIdx, i, nums);
                nonZeroIdx++;
            }
        }

    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
