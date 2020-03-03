package PhoneScreens.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-29
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) return "0";

        StringBuilder fraction = new StringBuilder();

        if (numerator < 0 ^ denominator < 0)
            fraction.append("-");

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0)
            return fraction.toString();

        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }

            map.put(remainder, fraction.length());
            remainder *= 10;

            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }

        return fraction.toString();
    }

    public String fractionToDecimal2(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if(numerator < 0 ^ denominator < 0)
            sb.append("-");

        long numLong = Math.abs(Long.valueOf(numerator));
        long denomLong = Math.abs(Long.valueOf(denominator));

        sb.append(numLong/denomLong);
        long remainder = numLong % denomLong;

        if(remainder == 0) return sb.toString();
        sb.append(".");

        //Store length of sb before adding a
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0){

            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder *= 10;

            sb.append(remainder/denomLong);
            remainder %= denomLong;
        }

        return sb.toString();
    }
}
