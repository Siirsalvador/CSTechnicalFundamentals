package UncategorizedChallenges;

import java.util.Arrays;

public class ZigZagArrayTraversal {

    public static int[] traverseArrayZigZaggly(int[] arrayInput) {
        //a<b>c<d>e<f>g
        boolean flag = true;

        for (int i = 0; i < arrayInput.length - 1; i++) {
            if (flag) {
                if (arrayInput[i] > arrayInput[i + 1]) {
                    int temp = arrayInput[i];
                    arrayInput[i] = arrayInput[i + 1];
                    arrayInput[i + 1] = temp;
                }
            } else {
                if (arrayInput[i] < arrayInput[i + 1]) {
                    int temp = arrayInput[i];
                    arrayInput[i] = arrayInput[i + 1];
                    arrayInput[i + 1] = temp;
                }
            }

            flag = !flag;
        }

        return arrayInput;
    }

    public static void main(String[] args) {
        int[] firstArray = {4, 3, 7, 8, 6, 2, 1};
        int[] secondArray = {1, 4, 3, 2};

        System.out.println(Arrays.toString(traverseArrayZigZaggly(firstArray)));
        System.out.println(Arrays.toString(traverseArrayZigZaggly(secondArray)));
    }
}
