package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-14
 */
public class IsPerfectSquare {
    public static void main(String[] args) {

        System.out.println((long)202051 * 202051); // Why we use long and not int
        System.out.println(isPerfectSquare(808201));
        System.out.println(2147395600==Integer.MAX_VALUE);
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int left = 2;
        int right = num / 2;

        while (left <= right) {

            if (left == right) {
                System.out.println(left);
            }

            int mid = left + (right - left) / 2;
            System.out.println("Mid: " + mid);

            if (mid * mid == num) {
                return true;
            }

            if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}