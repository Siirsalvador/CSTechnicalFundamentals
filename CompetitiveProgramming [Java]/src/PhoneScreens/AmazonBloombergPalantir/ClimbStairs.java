package PhoneScreens.AmazonBloombergPalantir;

import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */
public class ClimbStairs {

    static HashMap<Integer, Integer> stairsToSteps = new HashMap<>();

    public int climbStairs(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(!stairsToSteps.containsKey(n)){
            stairsToSteps.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }

        return stairsToSteps.get(n);
    }
}
