package Random.Others;

public class SecondLargestNumberInArray {


    private static int findSecondLargestNumberInArray(int[] arrayInput) {
        int firstMax = arrayInput[0];
        int secondMax = arrayInput[1];

        if (secondMax > firstMax) {
            int temp = firstMax;
            firstMax = secondMax;
            secondMax = temp;
        }

        for (int i = 2; i < arrayInput.length; i++) {
            if (arrayInput[i] > secondMax) {
                if (arrayInput[i] > firstMax) {
                    int temp = firstMax;
                    firstMax = arrayInput[i];
                    secondMax = temp;
                } else {
                    secondMax = arrayInput[i];
                }
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {

        int[] firstArray = {12, 1, 450, 14, 76, 91};
        //O(n) time
        System.out.println(findSecondLargestNumberInArray(firstArray));

    }
}
