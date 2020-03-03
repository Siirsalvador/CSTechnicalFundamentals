package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class SecondHighestNumInArr {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(findSecHighest(arr));
    }

    public static int findSecHighest(int[] arr) {
        if (arr.length < 2) return -1;

        int[] maxVal = new int[2];
        maxVal[0] = arr[0];
        maxVal[1] = arr[1];
        updateMaxValues(maxVal);

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > maxVal[1]) {
                maxVal[1] = arr[i];
                updateMaxValues(maxVal);
            }
        }

        return maxVal[1];
    }

    private static void updateMaxValues(int[] maxVal) {

        if (maxVal[1] > maxVal[0]) {
            int temp = maxVal[1];
            maxVal[1] = maxVal[0];
            maxVal[0] = temp;
        }
    }
}