package PhoneScreens.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-29
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int i : nums1) {
            numToFreq.putIfAbsent(i, 0);
            numToFreq.put(i, numToFreq.get(i) + 1);
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i : nums2) {
            if (numToFreq.containsKey(i) && numToFreq.get(i) > 0) {
                tmp.add(i);
                numToFreq.put(i, numToFreq.get(i) - 1);
            }
        }


        int[] result = new int[tmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmp.get(i);
        }

        return result;
    }

    /*
        Follow up:

        What if the given array is already sorted? How would you optimize your algorithm?
        - Binary Search

        What if nums1's size is small compared to nums2's size? Which algorithm is better?
        - Using two pointers, it will stop really early (@ shorter array)

        What if elements of nums2 are stored on disk, and the memory is limited such that
        you cannot load all elements into the memory at once?

        - Does this mean that num2 is bigger? I'm assuming yes
        - Go and sort it in place. Quicksort. Heap Sort. (nlogn)
        - use 2 pointers and load num2 in parts
        - Divide and conquer
     */
}
