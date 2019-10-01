package Pramp;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-20
 */
class IndexEqualsVal {

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] < mid) {
                //move right
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-8, 0, 2, 5};
        System.out.println(indexEqualsValueSearch(arr));

    }

}