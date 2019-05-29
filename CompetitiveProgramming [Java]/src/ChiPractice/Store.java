package ChiPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
 * There are two streams of integers that should be captured and stored in the order
 * they come in.
 * Implement a way to retrieve the n most recent integers stored
 */

class StoreSolution {
    public static void main(String[] args) {

    }
}

public class Store {

    LinkedList<Integer> numbers = new LinkedList<>();

    void addNumber(List<Integer> nums) {
        numbers.addAll(nums);
    }

    List<Integer> getMostRecent(int count) {
        ListIterator<Integer> iterator = numbers.listIterator(numbers.size());
        List<Integer> result = new ArrayList<>();
        while (count > 0) {
            if (iterator.hasPrevious()) {
                result.add(iterator.previous());
            }
            count -= 1;
        }

        return result;
    }
}
