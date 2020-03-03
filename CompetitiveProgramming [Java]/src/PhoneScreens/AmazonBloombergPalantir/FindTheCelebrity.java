package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-24
 */
public class FindTheCelebrity {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate && candidate >= 0) {
                candidate = !knows(candidate, i) && knows(i, candidate) ? candidate : -1;
            }
        }

        return candidate;
    }

    public int findCelebrityBrute(int n) {

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j) continue;
                if (knows(i, j)) {
                    res[i] = -1;
                    res[j] = res[j] == -1 ? -1 : res[j] + 1;
                }

            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == n - 1) return i;
        }

        return -1;
    }

    private boolean knows(int i, int j) {
        return true;
    }
}
