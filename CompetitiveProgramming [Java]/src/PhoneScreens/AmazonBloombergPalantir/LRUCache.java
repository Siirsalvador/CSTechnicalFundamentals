package PhoneScreens.AmazonBloombergPalantir;

import java.util.LinkedHashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-12
 */

class LRUCacheTest {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.
                println(cache.get(1));
        cache.put(3, 3);
        System.out.
                println(cache.get(2));
        cache.put(4, 4);
        System.out.
                println(cache.get(1));
        System.out.
                println(cache.get(3));
        System.out.
                println(cache.get(4));
        System.out.println(cache.map.entrySet());
    }
}

class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.remove(key);
            map.put(key, val);
            return val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == capacity) {
            for (Integer k : map.keySet()) {
                map.remove(k);
                break;
            }
        }

        map.put(key, value);
    }
}