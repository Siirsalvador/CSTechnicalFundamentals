package PhoneScreens.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-30
 */
public class IntersectionOfThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        List<Integer> res = new ArrayList<>();
        if (arr1 == null || arr1.length == 0) return res;
        if (arr2 == null || arr2.length == 0) return res;
        if (arr3 == null || arr3.length == 0) return res;

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        while (idx1 < arr1.length && idx2 < arr2.length && idx3 < arr3.length) {
            if (arr1[idx1] == arr2[idx2] && arr1[idx1] == arr3[idx3]) {
                res.add(arr1[idx1]);
                idx1++;
                idx2++;
                idx3++;
            } else if (arr1[idx1] < arr2[idx2]) {
                idx1++;
            } else if (arr2[idx2] < arr3[idx3]) {
                idx2++;
            } else {
                idx3++;
            }
        }

        return res;
    }
}
