package Firecode.MinEditDistance;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-25
 */
public class MinimumEditDistance {

    public int editDistance(String a, String b) {

        if(a == null && b == null) return 0;
        if(a == null || a.length() < 1) return b.length();
        if(b == null || b.length() < 1) return a.length();
        if( a.equals(b)) return 0;
        if(b.contains(a)) return b.length() - a.length();

        int[][] memo = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i < a.length(); i++) {
            memo[i][0] = i;
        }

        for (int j = 1; j < b.length(); j++) {
            memo[0][j] = j;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    memo[i][j] = 1 + min(memo[i][j - 1], memo[i - 1][j], memo[i - 1][j - 1]);
                }
            }
        }

        return memo[a.length()][b.length()];
    }

    private int min(int a, int b, int c) {
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while (true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i - 1] == str2[j - 1]) {
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j - 1] + 1) {
                System.out.println("Edit " + str2[j - 1] + " in string2 to " + str1[i - 1] + " in string1");
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i - 1]);
                i = i - 1;
            } else if (T[i][j] == T[i][j - 1] + 1) {
                System.out.println("Delete in string2 " + str2[j - 1]);
                j = j - 1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

}
