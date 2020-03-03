package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-19
 */
public class CustomMap<K, V> {

    /*
        Design a data structure with requirements:
        You have a <Key, Value> structured input data for all objects
        Where you have
        Insert : O(1)
        Lookup : O(1)
        Delete : O(1)
        You can traverse the added elements in the order they were inserted.

        ArrayList, hash then add to the back
        Lookup, use hashing to get idx then fetch Entry
        Delete, set hash to null


     */
    private int capacity;
    private MapEntry[] list;

    public CustomMap() {
        capacity = 25;
        list = new MapEntry[capacity];
    }

    public CustomMap(int capacity) {
        this.capacity = capacity;
        list = new MapEntry[capacity];
    }

    public static void main(String[] args) {
        CustomMap<Integer, Integer> numsMap = new CustomMap<>();
        numsMap.put(1, 12);
        numsMap.put(26, 235);
        numsMap.put(2, 40);
        numsMap.put(3, 60);

        numsMap.delete(26);
        System.out.println(numsMap.get(26));
    }

    public void put(K key, V value) {
        int hash = calculateHash(key);

        if (list[hash] == null) {
            list[hash] = new MapEntry<>(key, value);
        } else {
            MapEntry<K, V> curr = list[hash];
            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = new MapEntry<>(key, value);
        }
    }

    public V get(K key) {
        int hash = calculateHash(key);

        if (list[hash] != null) {
            MapEntry<K, V> curr = list[hash];

            while (curr != null) {
                if (curr.getKey() == key) return curr.getValue();
                curr = curr.next;
            }
        }

        return null;
    }

    public V delete(K key) {
        int hash = calculateHash(key);

        if (list[hash] == null) return null;

        MapEntry<K, V> curr = list[hash];

        if (curr.getKey() == key) {
            list[hash] = curr.next;
            return curr.getValue();
        }

        V v = null;
        while (curr.next != null) {
            if (curr.next.getKey() == key) {
                v = curr.next.getValue();
                curr.next = curr.next.next;
            }
        }

        return v;
    }

    private int calculateHash(K key) {
        return key.hashCode() % capacity;
    }

}

class MapEntry<K, V> {
    MapEntry<K, V> next;
    private K key;
    private V value;

    MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }
}