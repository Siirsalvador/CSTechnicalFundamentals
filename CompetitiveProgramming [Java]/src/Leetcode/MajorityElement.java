package Leetcode;

import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-11-01
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int size = nums.length;

        HashMap<Integer, Integer> numsToFreq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            if(numsToFreq.containsKey(nums[i])){
                numsToFreq.put(nums[i], numsToFreq.get(nums[i]) + 1);
            }else{
                numsToFreq.put(nums[i], 1);
            }

            if(numsToFreq.get(nums[i]) > size/2) {
                return nums[i];
            }

        }

        return -1;
    }
}
