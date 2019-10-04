package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-02
 */
public class BitSwapping {

    public static int swapOddEvenBits(int x) {

        System.out.println(Integer.toString(x, 2));

        //Obtain odd bits and shift to even position
        //Use 10101010 or 0xAA
        int odd = (x & 10101010) >> 1;
        System.out.println(Integer.toString(x & 0xAA, 2));

        //Obtain even bits and shift to odd position
        //Use 01010101 or 0x55
        int even = (x & 01010101) << 1;
        System.out.println(Integer.toString(x & 0x55, 2));

        return even | odd;
    }

    public static void main(String[] args) {
        System.out.println(swapOddEvenBits(200));
    }
}
