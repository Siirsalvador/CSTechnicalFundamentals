package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-03
 */
public class FindFirstDuplicate {
    private static int firstDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int max = nums.length;
        for (int i = 0; i < max; i++) {
            int val = nums[i] % max; // get the number which was originally in the array
            nums[val] += max; // add max to the number's "position" to show it has been visited
            if (nums[val] > 2 * max) { //check if we've visited it previously
                return val;
            }
        }
        return -1;
    }
}
