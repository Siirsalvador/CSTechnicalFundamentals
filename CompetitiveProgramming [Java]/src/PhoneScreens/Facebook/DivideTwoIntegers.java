package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-13
 */
public class DivideTwoIntegers {
    public static void main(String[] args){
        System.out.println(divide(Integer.MIN_VALUE, -3));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long dividendL = (long) dividend;
        long divisorL = (long) divisor;

        long absDividend = Math.abs(dividendL);
        long absDivisor = Math.abs(divisorL);
        int result = 0;

        while (absDividend >= absDivisor) {
            int shift = 0;
            while(absDividend >= (absDivisor << shift)){
                shift++;
            }

            result += 1 << (shift - 1);
            absDividend -= absDivisor << (shift - 1);
        }

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0))
            return result;

        return -1 * result;
    }

    public static int divideUnefficient(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        // if(divisor == -1) return -1 * dividend;
        long dividendL = (long) dividend;
        long divisorL = (long) divisor;

        long absDividend = Math.abs(dividendL);
        System.out.println(absDividend);
        long absDivisor = Math.abs(divisorL);
        int result = 0;
        while (absDividend > absDivisor) {
            System.out.println("Abs Dividend: " + absDividend);
            System.out.println("Abs Divisor: " + absDivisor);
            absDividend -= absDivisor;
            result++;
        }

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0))
            return result;
        return -1 * result;
    }
}
