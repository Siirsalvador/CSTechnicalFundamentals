package PhoneScreens.Palantir.Practice;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-29
 */
//Hackerrank: https://www.hackerrank.com/challenges/cipher/problem
public class Cipher {

    public static void main(String[] args) {

        int strLen = 10;
        int noOfShifts = 3;
        String encodedStr = "1110011011";

        System.out.println(cipher(noOfShifts,strLen, encodedStr));
    }

    // Complete the cipher function below.
    private static String cipher(int noOfShifts, int strLen, String s) {

        /*
            1110100110

            1001010
             1001010
              1001010
               1001010
            ----------
            1110100110

            1      0

            s.charAt(1), s.charAt(0)
            s.charAt(2), s.chartAt(1), s.charAt(0)
            s.charAt(7), s.charAt(6), s.charAt(5), s.charAt(4)

            int currBit = s.charAt(0)

            idx = 0 - 1
            (idx < k && idx >= 0){
                currBit = currBit ^ s.charAt(idx);
                idx--;
            }

         */
        String[] intStr = s.split("");
        ArrayList<Integer> sb = new ArrayList<>();
        for (int i = 0; i < strLen; i++) {
            int currBit = Integer.parseInt(intStr[i]);

            int currIdx = i - 1; // 0; 1 - 0; 2 - 1 - 0; 3 - 2 - 1 - 0; 4 - 3 - 2 - 1
            int count = noOfShifts - 1;

            while (count > 0 && currIdx >= 0) {
                currBit = currBit ^ sb.get(currIdx);
                count--;
                currIdx--;
            }

            sb.add(currBit);
        }

        while (sb.get(sb.size() - 1) == 0) {
            sb.remove(sb.size() - 1);
        }

        StringBuilder builder = new StringBuilder();
        for (Integer integer : sb) {
            builder.append(integer);
        }

        return builder.toString();
    }

    static String cipher(int k, String str) {
        char[] s = str.toCharArray();
        char[] result = new char[s.length - k + 1];
        result[0] = s[0];
        int i;
        for (i = 1; i < k; i++) {
            result[i] = s[i] == s[i - 1] ? '0' : '1';
        }
        for (; i < s.length - k + 1; i++) {
            result[i] = s[i] == s[i - 1] ?
                    result[i - k] : (result[i - k] == '1' ? '0' : '1');
        }
        return new String(result);
    }

    static String cipher(int k, String s, int n) {

        int[] c = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1')
                c[i] = 1;
        int[] r = new int[c.length + 1];
        int[] o = new int[c.length];
        r[c.length] = c[c.length - 1] ^ c[c.length - 1];
        o[c.length - 1] = c[c.length - 1];

        for (int i = c.length - 1; i > 0; i--) {

            if (c.length - i - 1 >= k)
                o[i] = c[i] ^ r[i + 1] ^ r[i + k];
            else
                o[i] = r[i + 1] ^ c[i];

            r[i] = o[i] ^ r[i + 1];
        }
        StringBuffer sb = new StringBuffer();
        for (int i = k - 1; i < o.length; i++)
            sb.append(o[i]);

        return sb.toString();

    }

}
