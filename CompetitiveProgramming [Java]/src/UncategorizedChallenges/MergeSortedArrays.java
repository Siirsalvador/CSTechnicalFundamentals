package UncategorizedChallenges;

import java.util.Arrays;
import java.util.TreeSet;

public class MergeSortedArrays {

    private static TreeSet<Integer> treeSetOfIntegers = new TreeSet<>();

    //Generics
    private static void insertIntoTreeMap(int[] arrayInput) {
        for (int i = 0; i < arrayInput.length; i++) {
            treeSetOfIntegers.add(arrayInput[i]);
        }
    }

    public static void main(String[] args) {
        int[] firstArray = {1, 3, 4, 5};
        int[] secondArray = {2, 4, 6, 8};

        insertIntoTreeMap(firstArray);
        insertIntoTreeMap(secondArray);

        //For more than 2 arrays
        //Enter number of Arrays
        //For that number, enter each array and call the TreeMap
        //Print the TreeMap.toArray() -> O(n) time

        System.out.println(Arrays.toString(treeSetOfIntegers.toArray()));
    }
}
