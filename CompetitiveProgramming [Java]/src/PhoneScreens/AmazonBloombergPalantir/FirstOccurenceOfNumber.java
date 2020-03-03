package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-18
 */
public class FirstOccurenceOfNumber {

    public static void main(String[] args){
        int[] arr = {1, 3, 5, 5, 5, 5 ,67, 123, 125};
        System.out.println(findFirstOccurrence(arr, 5));
    }

    public static int findFirstOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {

                if (mid - 1 >= 0 && target == nums[mid - 1]) {
                    end = mid - 1;
                } else {
                    return mid;
                }

            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
