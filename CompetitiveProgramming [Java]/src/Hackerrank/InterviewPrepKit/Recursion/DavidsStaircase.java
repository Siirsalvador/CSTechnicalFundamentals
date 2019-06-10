package Hackerrank.InterviewPrepKit.Recursion;

import java.util.Scanner;

public class DavidsStaircase {

    private static int[] dpArr;

    private static int stepPerms(int n) {

        if (n == 1 || n == 2)
            return n;

        if (n == 3)
            return 4;

        if(dpArr[n] == 0)
            dpArr[n] = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);

        return dpArr[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            dpArr = new int[n+1];

            int res = stepPerms(n);
            System.out.println(res);
        }

        scanner.close();
    }
}
