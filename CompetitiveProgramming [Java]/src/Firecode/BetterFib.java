package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-26
 */
public class BetterFib {
    public static int betterFibonacci(int n) {
        if (n < 2) return n;

        int firstPrev = 0;
        int secondPrev = 1;
        int i = 2;
        while (i < n) {
            int temp = secondPrev;
            secondPrev = firstPrev + secondPrev;
            firstPrev = temp;
            i++;
        }

        return firstPrev + secondPrev;
    }

    public static int fib(int n) {
        if(n < 2) return n;

        int prevNum = 0;
        int currentNum = 1;

        for(int i = 2; i <= n; i++){
            int nextNum = currentNum + prevNum;
            prevNum = currentNum;
            currentNum = nextNum;
        }

        return currentNum;
    }
}
