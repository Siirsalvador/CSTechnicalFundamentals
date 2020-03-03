package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class IntegerPowerSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 8, 9, 10, 11};
        System.out.println(subsets(nums));

        // 1 +
        //1:  2 ^ 7
        //2:  2 ^ 5
        //3:  2 ^ 3
        //4:  2 ^ 1
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {

            List<List<Integer>> temp = new ArrayList<>();

            for (List<Integer> list : res) {
                List<Integer> a = new ArrayList<>(list);
                a.add(num);
                temp.add(a);
            }

            res.addAll(temp);

        }

        return res;
    }
}
