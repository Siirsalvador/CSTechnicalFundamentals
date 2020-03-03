package PhoneScreens.AmazonBloombergPalantir;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-18
 */
public class ArrayRotation {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(leftRotate(a, 4)));
        System.out.println(Arrays.toString(rightRotate(a, 2)));
    }

    public static int[] leftRotate(int[] a, int d) {
        if (a == null || a.length == 0) return new int[0];

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int idx = i - d < 0 ? a.length - d + i : i - d;
            res[idx] = a[i];
        }

        return res;
    }

    public static int[] rightRotate(int[] a, int d) {
        if (a == null || a.length == 0) return new int[0];

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int idx = (i + d) % a.length;
            res[idx] = a[i];
        }

        return res;
    }
}
