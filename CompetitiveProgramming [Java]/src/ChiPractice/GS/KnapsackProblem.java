package ChiPractice.GS;// Java code for Dynamic Programming based
// solution for 0-1 Knapsack problem 

class KnapsackProblem {

    // A utility function that returns  
    // maximum of two integers 
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Prints the items which are put  
    // in a knapsack of capacity capacity
    static void printknapSack(int capacity, int wt[], int values[], int noOfItems) {
        int i, w;
        int K[][] = new int[noOfItems + 1][capacity + 1];

        // Build table K[][] in bottom up manner 
        for (i = 0; i <= noOfItems; i++) {

            for (w = 0; w <= capacity; w++) {

                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(values[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        // stores the result of Knapsack 
        int res = K[noOfItems][capacity];
//        System.out.println(res);

        w = capacity;
        for (i = noOfItems; i > 0 && res > 0; i--) {

            // either the result comes from the top 
            // (K[i-1][w]) or from (values[i-1] + K[i-1]
            // [w-wt[i-1]]) as in Knapsack table. If 
            // it comes from the latter one/ it means 
            // the item is included. 
            if (res == K[i - 1][w])
                continue;
            else {

                // This item is included. 
                System.out.print(wt[i - 1] + " ");

                // Since this weight is included its 
                // value is deducted 
                res = res - values[i - 1];
                w = w - wt[i - 1];
            }
        }
    }

    // Driver code 
    public static void main(String[] arg) {
        int[] valArr = {60, 100, 120};
        int[] weightArr = {10, 20, 30};
        int capacity = 50;
        int numberOfItems = valArr.length;

        printknapSack(capacity, weightArr, valArr, numberOfItems);
    }
} 