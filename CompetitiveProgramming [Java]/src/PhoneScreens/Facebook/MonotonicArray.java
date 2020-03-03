package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-14
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) return false;
        if (A.length == 1) return true;

        int first = 0;
        int second = 1;
        while (first < A.length && second < A.length && A[first] == A[second]) {
            first++;
            second++;
        }

        if (second >= A.length) return true;

        if (A[first] > A[second]) {
            return isDecreasing(A);
        } else {
            return isIncreasing(A);
        }
    }

    private boolean isDecreasing(int[] A) {

        int start = A[0];
        for (int i = 1; i < A.length; i++) {
            if (start < A[i]) return false;
            start = A[i];
        }

        return true;
    }

    private boolean isIncreasing(int[] A) {

        int start = A[0];
        for (int i = 1; i < A.length; i++) {
            if (start > A[i]) return false;
            start = A[i];
        }

        return true;
    }
}
