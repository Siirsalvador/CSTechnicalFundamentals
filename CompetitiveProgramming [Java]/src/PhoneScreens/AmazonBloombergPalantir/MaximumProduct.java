package PhoneScreens.AmazonBloombergPalantir;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-19
 */
public class MaximumProduct {

    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int lastIdx = nums.length - 1;

        if(nums[0] < 0 && nums[1] < 0 && nums[lastIdx] > 0){
            if(nums[0] * nums[1] > nums[lastIdx - 1] * nums[lastIdx - 2])
                return nums[0] * nums[1] * nums[lastIdx];
        }

        return nums[lastIdx] * nums[lastIdx - 1] * nums[lastIdx - 2];
    }
}
