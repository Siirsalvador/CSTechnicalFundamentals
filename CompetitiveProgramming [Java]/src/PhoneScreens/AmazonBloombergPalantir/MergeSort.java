package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class MergeSort {

    String str = "Ayo";
    public static void mergeSort(int[] arr, int start, int end) {

        if (start == end) return;

        while (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeHelper(arr, start, end);
        }
    }

    private static void mergeHelper(int[] arr, int start, int end) {

        int mid = start + (end - start) / 2;

        int firstIdx = start;
        int secIdx = mid + 1;

        int[] result = new int[arr.length];
        int resIdx = start;

        //compare two lists and add items to new list
        while (firstIdx <= mid && secIdx <= end) {

            if (arr[firstIdx] < arr[secIdx]) {
                result[resIdx] = arr[firstIdx];
                firstIdx++;
            } else {
                result[resIdx] = arr[secIdx];
                secIdx++;
            }

            resIdx++;
        }

        //check if there's any items left in first half of list
        while (firstIdx <= mid) {
            result[resIdx] = arr[firstIdx];
            resIdx++;
            firstIdx++;
        }

        //check if there's any items left in second half of list
        while (secIdx <= end) {
            result[resIdx] = arr[secIdx];
            resIdx++;
            secIdx++;
        }

        while (start <= end) {
            arr[start] = result[start];
            start++;
        }

    }

}
