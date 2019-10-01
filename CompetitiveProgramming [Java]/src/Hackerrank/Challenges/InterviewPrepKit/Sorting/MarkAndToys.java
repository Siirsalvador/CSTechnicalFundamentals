package Hackerrank.Challenges.InterviewPrepKit.Sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-15
 */
public class MarkAndToys {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] counts = scanner.nextLine().split(" ");

        if (counts.length > 2) {
            throw new IllegalArgumentException("The first line should only contain the number of prices and the spending amount");
        }

        int priceListLength = Integer.parseInt(counts[0]);
        int spendingAmt = Integer.parseInt(counts[1]);

        String[] priceItems = scanner.nextLine().split(" ");

        if (priceItems.length != priceListLength) {
            throw new IllegalArgumentException("The number of prices should match the price list length");
        }

        int[] prices = new int[priceListLength];

        for (int i = 0; i < priceListLength; i++) {
            prices[i] = Integer.parseInt(priceItems[i]);
        }

        int result = maximumToys(prices, spendingAmt);

        System.out.println(result);

        scanner.close();

    }

    private static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);

        int count = 0;
        int currSpend = 0;

        for(int price : prices){
            if((currSpend + price) > k){
                break;
            }else {
                currSpend += price;
                count++;
            }
        }

        return count;
    }
}
