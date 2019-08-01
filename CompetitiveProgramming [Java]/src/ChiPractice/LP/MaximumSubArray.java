package ChiPractice.LP;

import java.util.Arrays;

/*
 * Find the subarray in a array of ints with largest sum
 */
public class MaximumSubArray {

    public static void main(String[] args) {

        // [1, 2, 4, -10, -3, 5 ,7]
        // 1 + 2 + 4 (= 7) + (-10) !> 7
        //[7-> (0,2); 15- >(4, 6)]

        // 1, 2, 3, -10, -3, 5, 8, -5, 8, 9

        // w_sum = 8, w_start=5, w_end=6,
        // max_sum = 8,
        // start = 0,
        // end = 2
        int[] array = new int[]{1,2,19,-1,-3,6,9,-40,5,2};
        System.out.println(Arrays.toString(getMaxSubArray(array)));
    }

    private static int[] getMaxSubArray (int[] array) {
        int w_sum = 0, w_start = 0,
                max_sum = Integer.MIN_VALUE, start = 0, end = 0;

        for(int i=0; i<array.length; i++) {
            w_sum += array[i];

            // Working sum is the new max sum
            if(w_sum > max_sum){
                start = w_start;
                end = i;
                max_sum = w_sum;
                continue;
            }

            //We encounter a significantly large negative number
            if(w_sum < 0 ) {
                w_start = i+1;
                w_sum = 0;
            }
        }

        return Arrays.copyOfRange(array, start, end+1);
    }
}
