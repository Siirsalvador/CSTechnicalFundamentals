package DailyCodingProblem;

public class DCP74_MultiplicationTableMode {

    public static void main(String[] args) {

        findNumberOfAppearances(6, 12);
        findNumberOfAppearances(4, 1);
    }

    private static void findNumberOfAppearances(int multiplicationTableSize, int numberToSearchFor) {
        int count = 0;
        for (int i = 0; i < multiplicationTableSize; i++) {
            if (numberToSearchFor % (i + 1) == 0 && (numberToSearchFor / (i + 1)) <= multiplicationTableSize) {
                count++;
            }
        }

        System.out.println(count);
    }
}
