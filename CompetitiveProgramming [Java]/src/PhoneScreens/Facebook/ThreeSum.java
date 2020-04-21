package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-03
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            Set<Integer> visited = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                if (visited.contains(-(nums[i] + nums[j]))) {
                    tmp.add(nums[i]);
                    tmp.add(-(nums[i] + nums[j]));
                    tmp.add(nums[j]);
                    res.add(tmp);
                    tmp = new ArrayList<>();
                }

                visited.add(nums[j]);
            }
        }

        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int stop = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (start < stop) {
                if (stop < nums.length - 1 && nums[stop] == nums[stop + 1]) {
                    stop--;
                    continue;
                }

                if (nums[i] + nums[start] + nums[stop] > 0) {
                    stop--;
                } else if (nums[i] + nums[start] + nums[stop] < 0) {
                    start++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[stop]);
                    res.add(list);
                }

                start++;
                stop--;
            }
        }

        return new ArrayList<>(res);
    }
}
