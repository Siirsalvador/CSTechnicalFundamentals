package PhoneScreens.Microsoft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-08
 */
public class NumberStepsToTarget {

    public static void main(String[] args) {
        int t = 19;
        System.out.println(findMinTime(t));
    }

    public static int findMinTime(int target) {
        int l = 0;
        int r = 1;

        return minTimeUtil(l, r, target);
    }

    private static int minTimeUtil(int l, int r, int target) {

        if (l == target || r == target) {
            return 0;
        }

        int min1 = 0;
        int min2 = 0;

        if (l != Integer.MIN_VALUE && l != Integer.MAX_VALUE) {
            min1 = minTimeUtil(2 * l - r, r, target);
        }

        if (r != Integer.MIN_VALUE && r != Integer.MAX_VALUE) {
            min2 = minTimeUtil(l, 2 * r - l, target);
        }


        System.out.println("L: " + l);
        System.out.println("R: " + r);

        return 1 + Math.min(min1, min2);
    }

    public static int findMinTimeQueue(int target) {

        Queue<Number> nums = new LinkedList<>();
        nums.offer(new Number(0, 1, 0));

        while (!nums.isEmpty()) {
            Number curr = nums.poll();
            int l = curr.left;
            int r = curr.right;
            int lvl = curr.level;

            if (curr.left == target || curr.right == target) return curr.level;

            if (curr.left != Integer.MIN_VALUE && curr.left != Integer.MAX_VALUE) {
                nums.offer(new Number(2 * l - r, r, lvl + 1));
            }

            if (curr.right != Integer.MIN_VALUE && curr.right != Integer.MAX_VALUE) {
                nums.offer(new Number(l, 2 * r - l, lvl + 1));
            }
        }

        return 0;
    }
}

class Number {
    int left;
    int right;
    int level;


    Number(int left, int right, int level) {
        this.left = left;
        this.right = right;
        this.level = level;

    }
}
//Use a queue

/*
    -1

  l  0
  r  1

  l  2 * 0 - 1 = -1 (stop)

  r  2 * 1 - 0 = 2 => 0, 2

    0

 */