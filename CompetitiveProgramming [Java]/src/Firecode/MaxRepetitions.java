package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class MaxRepetitions {

    public static int getMaxRepetition(int[] a) {

        int[] numbers = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            numbers[a[i]]++;
        }

        int maxNum = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[maxNum]) maxNum = i;
        }

        return maxNum;
    }

    public static int getMaxRepetition2(int[] a) {

        for (int i = 0; i < a.length; ++i) {
            //Updates the idx equal to the val each time, so that at the end, the max is what we take.
            a[a[i] % a.length] += a.length;
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 3, 3, 4};
        System.out.println(getMaxRepetition2(arr));
    }
}
