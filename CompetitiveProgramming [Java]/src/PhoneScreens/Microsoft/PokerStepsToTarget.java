package PhoneScreens.Microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-08
 */
public class PokerStepsToTarget {


    public static void main(String[] args) {
        System.out.println(findMinTimeQueue(30000, 21));
    }

    public static int findMinTime(int target, int maxAllIns) {
        HashMap<String, Integer> map = new HashMap<>();
        return findMinTimeUtil(1, target, maxAllIns, map);

    }

    private static int findMinTimeUtil(int curr, int target, int maxAllIns, HashMap<String, Integer> map) {

        if (curr > target) {
            return Integer.MAX_VALUE;
        }

        if (curr == target) {
            return 0;
        }

        if (maxAllIns == 0) {
            return target - curr;
        }

        String key = curr +
                ":" +
                maxAllIns;

        if (!map.containsKey(key)) {
            int min1 = findMinTimeUtil(curr + 1, target, maxAllIns, map);
            int min2 = findMinTimeUtil(curr * 2, target, maxAllIns - 1, map);

            map.put(key, Math.min(min1, min2));
        }

        return 1 + map.get(key);
    }

    public static int findMinTimeQueue(int target, int maxAllIns) {

        Queue<Node> chips = new LinkedList<>();
        chips.add(new Node(1, 0, 0));

        while (!chips.isEmpty()) {
            Node curr = chips.poll();

            if (curr.chipCount == target) return curr.level;
            if (curr.chipCount > target) continue;

            chips.offer(new Node(curr.chipCount + 1, curr.currAllIns, curr.level + 1));

            if (curr.currAllIns != maxAllIns) {
                chips.offer(new Node(curr.chipCount * 2, curr.currAllIns + 1, curr.level + 1));
            }

        }

        return 0;
    }
}


class Node {
    int chipCount;
    int currAllIns;
    int level;

    Node() {
    }

    Node(int chipCount, int currAllIns, int level) {
        this.chipCount = chipCount;
        this.currAllIns = currAllIns;
        this.level = level;
    }

    public void setChipCount(int chipCount) {
        this.chipCount = chipCount;
    }

    public void setCurrAllIns(int currAllIns) {
        this.currAllIns = currAllIns;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
/*

    1

     1 + 1 = 2 : 1 * 2 = 2

     2 + 1 = 3 : 2 * 2 = 4


 */