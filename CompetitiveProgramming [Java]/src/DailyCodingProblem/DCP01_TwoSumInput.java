package DailyCodingProblem;

import java.util.HashMap;

public class DCP01_TwoSumInput {

    public static void main(String[] main) {
        int[] arrayOfNum = {10, 15, 3, 7};
        int k = 17;

        System.out.println(checkForTwoNumbersSum(arrayOfNum, k));
    }

    public static boolean checkForTwoNumbersSum(int[] arrayOfNum, int k) {

        if (arrayOfNum == null || arrayOfNum.length == 0)
            return false;

        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for (int i = 0; i < arrayOfNum.length; i++) {
            if (!integerHashMap.containsKey(arrayOfNum[i])) {
                integerHashMap.put(arrayOfNum[i], 1);
            } else {
                integerHashMap.replace(arrayOfNum[i], integerHashMap.get(arrayOfNum[i]), integerHashMap.get(arrayOfNum[i]) + 1);
            }
        }

        for (int i = 0; i < arrayOfNum.length; i++) {
            if (integerHashMap.containsKey(k - arrayOfNum[i]) && k - arrayOfNum[i] == arrayOfNum[i]) {
                //Checks if the number appears more than once in the input
                return integerHashMap.get(k - arrayOfNum[i]) > 1;
            } else if (integerHashMap.containsKey(k - arrayOfNum[i]))
                return true;
        }


        return false;
    }
}
