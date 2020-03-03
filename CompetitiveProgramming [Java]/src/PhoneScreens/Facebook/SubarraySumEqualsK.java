package PhoneScreens.Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-26
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //System.out.println(subarraySum(nums, 0));

        int[] nums2 = {1, 1, 1};
        System.out.println(subarraySum2(nums2, 2));
    }

    /*
        Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

        Example 1:

        Input:
        nums = [1,1,1], k = 2

        Output:
        2

        Note:
        The length of the array is in range [1, 20,000].
        The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */
    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];

            for (int j = i + 1; j <= nums.length; j++) {
                if (sum == k) {
                    count += 1;
                }

                sum = j == nums.length ? 0 : sum + nums[j];
            }

        }

        return count;
    }

    /**
     * Cumulative Sum
     */
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;

        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        System.out.println(Arrays.toString(sum));

        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }

        return count;
    }


    /**
     * Using Hashmap
     * 5 - 3 = 2
     */
    public static int subarraySum3(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        int count = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sumFreq.containsKey(sum - k)){
                count += sumFreq.get(sum - k);
            }

            sumFreq.putIfAbsent(sum, 0);
            sumFreq.put(sum, sumFreq.get(sum) + 1);
        }

        return count;
    }
}
