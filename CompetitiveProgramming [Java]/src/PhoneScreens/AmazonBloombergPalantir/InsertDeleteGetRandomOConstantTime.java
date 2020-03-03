package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-02
 */
public class InsertDeleteGetRandomOConstantTime {
}


class RandomizedSet2 {

    /**
     * Initialize your data structure here.
     */
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet2() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int valIdx = map.get(val);
        int lastVal = list.get(list.size() - 1);

        map.put(lastVal, valIdx);
        list.set(valIdx, lastVal);

        map.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
