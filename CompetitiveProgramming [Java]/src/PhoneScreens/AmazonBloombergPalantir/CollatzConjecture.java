package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class CollatzConjecture {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(collatzConjecture(n));
    }

    //Time Complexity is undefined
    //Space Complexity is undefined
    public static ArrayList<Integer> collatzConjecture(int num) {
        ArrayList<Integer> nums = new ArrayList<>();
        if (num < 0) return nums;

        nums.add(num);
        while (nums.get(nums.size() - 1) != 1) {

            int prev = nums.get(nums.size() - 1);

            if (prev % 2 == 0) {
                int next = prev / 2;
                nums.add(next);
            } else {
                int next = (3 * prev) + 1;
                nums.add(next);
            }
        }

        return nums;
    }
}
