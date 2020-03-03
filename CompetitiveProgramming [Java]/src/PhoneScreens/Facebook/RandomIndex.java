package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class RandomIndex {

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1, 1, 1});
        System.out.println(s.pick(1));
    }
}

class Solution {

    Map<Integer, List<Integer>> map;
    Random r;

    public Solution(int[] nums) {
        map = new HashMap<>();
        r = new Random();
        insertIntoMap(nums);
    }

    private void insertIntoMap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        if (!map.containsKey(target)) return -1;

        List<Integer> l = map.get(target);
        int idx = r.nextInt(l.size());
        return l.get(idx);
    }
}

/**
 * Random Sampling
 */
class Solution2 {
    int[] nums;
    Random r;

    public Solution2(int[] nums) {
        r = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;

        //To ensure we find at least one index
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) {
                result = i;
                break;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target && r.nextInt(++count) == 0) {
                result = i;
            }
        }

        return result;
    }
}