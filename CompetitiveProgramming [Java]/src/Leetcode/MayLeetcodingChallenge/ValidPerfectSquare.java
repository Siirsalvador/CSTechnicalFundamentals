package Leetcode.MayLeetcodingChallenge;

/**
 * @author: aoyekanmi
 * @date: 2020-05-09
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;

        int limit = num/2;
        int i = 1;
        while(i++ <= limit){
            if(i * i == num)
                return true;
        }

        return false;
    }
}
