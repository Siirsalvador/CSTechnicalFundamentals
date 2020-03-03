package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-29
 */

class RandomizedSet {

    //ArrayList

    //Hash key, use hashed value as mem addy
    //Since we don't know the size ahead of time, we can use an arraylist
    Random rand = new Random();
    ArrayList<Integer> array;
    HashMap<Integer, Integer> valueToIdx;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        array = new ArrayList<>();
        valueToIdx = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueToIdx.containsKey(val)) return false;

        array.add(val);
        valueToIdx.put(val, array.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valueToIdx.containsKey(val)) return false;

        int idxToRemove = valueToIdx.get(val);
        int lastVal = array.get(array.size() - 1);

        array.set(idxToRemove, lastVal);
        array.remove(array.size() - 1);

        valueToIdx.put(lastVal, idxToRemove);
        valueToIdx.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int idx = rand.nextInt(array.size());
        return array.get(idx);
    }
}
