package Firecode;

import java.util.HashSet;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-23
 */
public class HappyNum {

    public static boolean isHappyNumber(int n) {
        int sum = n;
        boolean repeat = true;

        HashSet<Integer> vals = new HashSet<>();
        do {
            sum = next(sum);
            if(sum == 1) break;
            if(!vals.add(sum)) repeat = false;
        } while (repeat);

        return sum == 1;
    }

    private static int next(int n) {
        int res = 0;
        while (n > 0) {
            //find modulo 10
            int digit = n % 10;
            //add square to res
            res += (digit * digit);
            //divide by 10
            n /= 10;
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(isHappyNumber(68));
    }
}
