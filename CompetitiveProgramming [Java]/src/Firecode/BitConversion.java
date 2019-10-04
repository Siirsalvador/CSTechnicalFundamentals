package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-01
 */
public class BitConversion {

    public static int bitSwapRequired(int a, int b) {

        String aStr = Integer.toString(a, 2);
        String bStr = Integer.toString(b, 2);

        int count = 0;
        for (int i = 0; i < aStr.length(); i++) {
            int curr = aStr.charAt(i) ^ bStr.charAt(i);
            if (curr == 1) count++;
        }

        return count;
    }

    public static int bitSwapRequired2(int a, int b) {
        int c = a ^ b;
        int count = 0;
        while (c != 0) {
            if ((c & 1) == 1) {
                count++;
            }
            c = c >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bitSwapRequired(21, 31));
    }


}
