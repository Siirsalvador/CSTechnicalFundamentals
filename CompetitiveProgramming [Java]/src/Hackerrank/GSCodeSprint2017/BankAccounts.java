package Hackerrank.GSCodeSprint2017;

import java.util.Scanner;

public class BankAccounts {

    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        int maxBankCharge = k;
        int bankChargePercentage = x;
        int upfrontFee = d;
        int[] arrayOfPrices = p;
        double totalFee = 0;

        for (int price : arrayOfPrices) {
            totalFee += Math.max(maxBankCharge, bankChargePercentage * price / 100.0);
        }

        if (totalFee == upfrontFee)
            return "fee";
        return totalFee < upfrontFee ? "fee" : "upfront";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for (int p_i = 0; p_i < n; p_i++) {
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }
}