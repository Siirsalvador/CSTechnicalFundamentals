package Hackerrank.Challenges.InterviewPrepKit.Sorting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-17
 */
public class FraudulentActivityNotifications {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        scanner.close();
        System.out.println(activityNotifications(expenditure, d));

    }

    private static int activityNotifications(int[] expenditure, int d) {

        int notificationCount = 0;

        //Tried to sort my array every time and the time complexity of my solution become n * nlog(n) ---> a disaster
        //So the importance of using a frequency array became obvious. Quite frankly, this is what I call creativity in programming :)

        int[] frequency = new int[201];
        Queue<Integer> trailingPrices = new LinkedList<>();

        for (int i = 0; i < expenditure.length; i++) {
            while (i < d) {
                trailingPrices.add(expenditure[i]);
                frequency[expenditure[i]] = frequency[expenditure[i]] + 1;
                i++;
            }

            float median = getMedian(frequency, d);

            if (expenditure[i] >= 2 * median) notificationCount++;

            //Remove earliest price
            int elementToRemove = trailingPrices.remove();
            frequency[elementToRemove] = frequency[elementToRemove] - 1;

            //Add new price
            trailingPrices.add(expenditure[i]);
            frequency[expenditure[i]] = frequency[expenditure[i]] + 1;
        }

        return notificationCount;
    }

    private static float getMedian(int[] frequency, int d) {

        int center = 0;

        if (d % 2 != 0) {
            for (int i = 0; i < frequency.length; i++) {

                center = center + frequency[i];

                if (center > d / 2) {
                    return i;
                }
            }

        } else {

            int first = -1, second;

            for (int i = 0; i < frequency.length; i++) {
                center = center + frequency[i];

                if (center == d / 2) {
                    first = i;
                } else if (center > d / 2) {

                    if (first < 0) first = i;
                    second = i;

                    return ((float) first + (float) second) / 2;
                }
            }

        }

        return 0;

    }
}
