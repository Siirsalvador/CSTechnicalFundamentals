package Leetcode.MayLeetcodingChallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: aoyekanmi
 * @date: 2020-05-13
 */
public class RemoveKDigitsRecursive {
    public String removeKdigits(String num, int k) {
        int[] minNum = {Integer.parseInt(num)};
        helper(num, k, 0, new HashSet<>(), minNum);
        return String.valueOf(minNum[0]);
    }

    private void helper(String num, int k, int idx, Set<Integer> set, int[] min){
        if(k == 0){
            int currNum = 0;
            String curr = "";
            for(int i = 0; i < num.length(); i++){
                char c = num.charAt(i);
                if(set.contains(i)) continue;
                curr = curr + c;
            }

            if(!curr.equals(""))
                currNum = Integer.parseInt(curr);

            System.out.println(currNum);
            min[0] = Math.min(min[0], currNum);
            return;
        }

        for(int i = idx; i < num.length(); i++){
            set.add(i);
            helper(num, k - 1, idx + 1, set, min);
            set.remove(i);
        }
    }
}
