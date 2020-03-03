package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-25
 */
public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        /**
         [2,3,-2,-4,-7]
         2 * 3 * -2 * - 4 = 24;
         */

        int max = nums[0], currMax = nums[0], currMin = nums[0];
        for (int i = 1; i < nums.length; i++) {

            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(currMax * nums[i], currMin * nums[i]));

            max = Math.max(currMax, max);
        }

        return max;
    }
}
