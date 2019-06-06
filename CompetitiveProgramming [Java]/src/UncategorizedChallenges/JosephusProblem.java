package UncategorizedChallenges;

import java.io.InputStream;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 * There are n people standing in a circle, given a number k which represents the number of people to be skipped before killing someone,
 * Find the index of the person who will remain alive
 */

public class JosephusProblem {

    private static int findLivingIndex(ArrayList<Integer> listOfIndexes, int startingIndex, int numberToSkip) {

        if (listOfIndexes.size() == 0)
            System.out.println("Nobody lived");

        if (listOfIndexes.size() == 1)
            return listOfIndexes.get(0);

        int deleteIdx = (startingIndex + (numberToSkip - 1)) % listOfIndexes.size();
        listOfIndexes.remove(deleteIdx);

        return findLivingIndex(listOfIndexes, deleteIdx, numberToSkip);
    }

    private static int josephusN(int numberOfPeople, int numberToSkip) {

        if (numberOfPeople == 1)
            return 1;

        if (numberOfPeople == 2)
            return 1;

        return (josephusN(numberOfPeople - 1, numberToSkip) + numberToSkip - 1) % numberOfPeople + 1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> listOfIdxs = new ArrayList<>();
        int numberOfPeople = 41;
        for (int i = 0; i < numberOfPeople; i++) {
            listOfIdxs.add(i + 1);
        }

        System.out.println(findLivingIndex(listOfIdxs, 0, 2));

        System.out.println(josephusN(41, 2));
    }

}
