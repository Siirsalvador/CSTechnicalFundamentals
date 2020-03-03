package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-13
 */
public class FirstUniqueNumInArray {

    public static int findIdxOfUniqueNum(int[] arr) {

        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];
        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (freq[arr[i]] == 1) return i;
        }

        return -1;
    }

    public static void main(String[] args){
    }
}
