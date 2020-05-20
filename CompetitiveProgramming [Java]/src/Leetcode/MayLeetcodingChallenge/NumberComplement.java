package Leetcode.MayLeetcodingChallenge;

/**
 * @author: aoyekanmi
 * @date: 2020-05-04
 */
public class NumberComplement {

    public int findComplementInefficient(int num) {

        String binary = "";
        while (num > 0) {
            int remainder = num % 2;
            binary = remainder + "" + binary;
            num /= 2;
        }

        String complement = "";
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c == '1')
                complement += '0';
            else
                complement += '1';
        }

        return Integer.parseInt(complement, 2);
    }
}
