package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-13
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        // backtracking: what do we care about?
        // I want to try summing items to each index until I get to sum/2
        // I want to know the number of items involved in the summing
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        return helper(0, nums, 0, sum / 2);
    }

    private boolean helper(int start, int[] nums, int currSum, int targetSum) {
        if (currSum == targetSum)
            return true;

        if (start == nums.length || currSum > targetSum) return false;

        if (helper(start + 1, nums, currSum + nums[start], targetSum))
            return true;

        int j = start + 1;
        while (j < nums.length && nums[start] == nums[j]) {
            j++;
        }

        return helper(j, nums, currSum, targetSum);
    }
}
