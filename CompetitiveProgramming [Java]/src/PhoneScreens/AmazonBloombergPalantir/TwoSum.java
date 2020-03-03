package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class TwoSum {

    public static void main(String[] args) {
        //int[] nums = {1, 1, 1, 1, 2, 0, 1, 1, 0, 2};
        int[] nums = {20, 50, 40, 25, 30, 10};
        System.out.println(getHighestSumPair(nums, 60));
    }

    public static ArrayList<Integer> getHighestSumPair(int[] nums, int target) {

        if (nums == null) return new ArrayList<>();

        HashMap<Integer, Integer> numToFreq = new HashMap<>();
        ArrayList<ArrayList<Integer>> allPairs = new ArrayList<>();
        for (int num : nums) {

            int diff = target - num;

            if (numToFreq.containsKey(diff) && numToFreq.get(diff) > 0) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(diff);
                pair.add(num);

                allPairs.add(pair);
                numToFreq.put(diff, numToFreq.get(diff) - 1);
            } else {
                numToFreq.putIfAbsent(num, 0);
                numToFreq.put(num, numToFreq.get(num) + 1);
            }
        }

        int highestIdx = 0;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < allPairs.size(); i++) {

            ArrayList<Integer> pair = allPairs.get(i);

            if (pair.get(0) > maxNum) {
                maxNum = pair.get(0);
                highestIdx = i;

            }

            if (pair.get(1) > maxNum) {
                maxNum = pair.get(1);
                highestIdx = i;
            }
        }

        return allPairs.get(highestIdx);
    }

    public static ArrayList<ArrayList<Integer>> sumPairs(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        HashMap<Integer, Integer> numToIdx = new HashMap<>();
        ArrayList<Integer> pair = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int sec = target - nums[i];

            if (numToIdx.containsKey(sec)) {
                pair.add(nums[i]);
                pair.add(sec);

                numToIdx.remove(sec);

                result.add(pair);
                pair = new ArrayList<>();

            } else {
                numToIdx.put(nums[i], i);
            }
        }

        return result;
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numToIdx = new HashMap<>();
        int[] idxs = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];

            if (numToIdx.containsKey(other)) {
                idxs[0] = numToIdx.get(other);
                idxs[1] = i;
                return idxs;
            } else {
                numToIdx.put(nums[i], i);
            }
        }

        return idxs;
    }
}
