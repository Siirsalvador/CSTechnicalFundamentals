package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-18
 */
public class ArrayRotation {

    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        System.out.println(Arrays.toString(leftRotate(a, 2)));
//        System.out.println(Arrays.toString(rightRotate(a, 2)));

        char[] c = "xqgwkiqpif".toCharArray();
        System.out.println(leftRotate(c, 26));
    }

    public static int[] leftRotate(int[] a, int d) {
        if (a == null || a.length == 0) return new int[0];

        d = d % a.length;
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int idx = i - d < 0 ? a.length - d + i : i - d;
            res[idx] = a[i];
        }

        return res;
    }

    public static String leftRotate(char[] a, int d) {
        if (a == null || a.length == 0) return "";

        d = d % a.length;
        char[] res = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            int idx = i - d < 0 ? a.length - d + i : i - d;
            res[idx] = a[i];
        }

        return new String(res);
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
