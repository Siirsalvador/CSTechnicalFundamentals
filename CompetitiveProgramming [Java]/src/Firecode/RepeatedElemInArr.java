package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-29
 */
public class RepeatedElemInArr {
    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.
    public static void main(String[] args) {

    }

    public static String duplicate(int[] numbers) {
        //find max
        //Create an arr[max + 1]
        //loop through numbers, everytime I get to arr[number]++
        //Create ArrayList, add every element > 1 to list

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (max < numbers[i]) max = numbers[i];
        }

        int[] arr = new int[max + 1];
        for (int number : numbers) {
            arr[number]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) list.add(i);
        }

        return list.toString();
    }
}
