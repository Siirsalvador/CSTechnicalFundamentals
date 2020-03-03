package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-19
 */
public class FirstMissingPositive {

    public static void main(String[] arg) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != i) {
                int temp = nums[nums[i]]; //pos 3
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return -1;
    }
}
