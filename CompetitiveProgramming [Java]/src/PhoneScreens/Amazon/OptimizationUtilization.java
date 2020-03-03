package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-15
 */
public class OptimizationUtilization {

    public static void main(String[] args) {

        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 8});
        a.add(new int[]{2, 15});
        a.add(new int[]{3, 9});

        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1, 8});
        b.add(new int[]{2, 11});
        b.add(new int[]{3, 12});

        System.out.println(Arrays.toString(getOptimalUtilization(a, b, 20)));
    }

    public static int[] getOptimalUtilization(List<int[]> a, List<int[]> b, int target) {
        if (a == null || a.isEmpty()) return new int[0];
        if (b == null || b.isEmpty()) return new int[0];

        a.sort(new ArrayComparator());
        b.sort(new ArrayComparator());

        int aIdx = a.size() - 1;
        int bIdx = 0;

        int maxVal = Integer.MIN_VALUE;
        int maxAIdx = 0;
        int maxBIdx = 0;

        while (aIdx >= 0 && bIdx < b.size()) {
            int aNum = a.get(aIdx)[1];
            int bNum = b.get(bIdx)[1];
            int curr = aNum + bNum;

            if (curr <= target && curr > maxVal) {
                maxVal = curr;
                maxAIdx = a.get(aIdx)[0];
                maxBIdx = b.get(bIdx)[0];
            }

            if (curr == target) return new int[]{maxAIdx, maxBIdx};

            if (curr < target) {
                bIdx++;
            } else if (curr > target) {
                aIdx--;
            }

        }
        return new int[]{maxAIdx, maxBIdx};
    }

}

class ArrayComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return a[1] - b[1];
    }
}