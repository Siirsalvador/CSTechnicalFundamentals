package PhoneScreens.Facebook;

import java.util.Arrays;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-24
 */
public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));

        int n = 9925;
//        char[] arr = {'0', '1', '2', '3'};
//        System.out.println(Integer.valueOf(new String(arr)));
    }

    public static int maximumSwap(int num) {


        char[] arr = String.valueOf(num).toCharArray();
        char[] ans = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                System.out.println("<---------------------------------------->");

                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                System.out.println("arr (after swap): " + Arrays.toString(arr));
                System.out.println("ans (before swap): " + Arrays.toString(ans));
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] != ans[k]) {
                        if (arr[k] > ans[k]) {
                            ans = Arrays.copyOf(arr, arr.length);
                            System.out.println("ans (after swap): " + Arrays.toString(ans));
                        }
                        break;
                    }
                }

                System.out.println("<---------------------------------------->");

                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

        return Integer.valueOf(new String(ans));
    }

    public int maximumSwap2(int num) {
        String numStr = String.valueOf(num);
        int[] arr = new int[numStr.length()];
        for(int i = 0; i < numStr.length(); i++){
            arr[i] = numStr.charAt(i) - '0';
        }
        for(int i = 0; i < arr.length - 1; i++){
            int curr = arr[i];
            int jIdx = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] >= curr){
                    curr = arr[j];
                    jIdx = j;
                }
            }
            if(arr[jIdx] > arr[i]){
                int temp = arr[jIdx];
                arr[jIdx] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            res = (res * 10)+ arr[i];
        }
        return res;
    }

    public static int maximumSwap3(int num) {

        char[] arr = String.valueOf(num).toCharArray();
        int[] digitIdx = new int[10];

        for (int i = 0; i < arr.length; i++) {
            digitIdx[arr[i] - '0'] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int d = 9; d > arr[i] - '0'; d--) {
                if (digitIdx[d] > i) {
                    char temp = arr[i];
                    arr[i] = arr[digitIdx[d]];
                    arr[digitIdx[d]] = temp;

                    return Integer.valueOf(new String(arr));
                }
            }
        }


        return num;
    }
}
