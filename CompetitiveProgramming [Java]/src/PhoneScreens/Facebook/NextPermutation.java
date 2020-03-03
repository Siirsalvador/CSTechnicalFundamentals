package PhoneScreens.Facebook;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println((Arrays.toString(nums)));
    }

    public static void nextPermutation(int[] nums) {

        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1])
            idx--;

        if (idx >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[idx] >= nums[j])
                j--;
            swap(idx, j, nums);
        }

        reverse(idx + 1, nums);
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int s, int[] nums) {
        int start = s;
        int end = nums.length - 1;

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}

