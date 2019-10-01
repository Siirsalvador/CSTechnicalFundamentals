package Hackerrank.Algorithms.Strings;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-04
 */
public class HackerrankInAString {

    //put all chars in a list for word
    //put all chars in a list for hackerrank
    //for each char in hackerrank, check if it exists in the list of chars for the word
    //if a char in hackerrank exists in the word, move idx forward by 1 for both of them. increment count.
    //if a char does not exist, move the idx of the list of chars for the word by 1

    static String hackerrankInString(String s) {

        String HACKERRANK = "hackerrank";

        char[] hackerrankArr = HACKERRANK.toCharArray();
        char[] wordArr = s.toCharArray();

        int j = 0;
        int contains = 0;
        for (int i = 0; i < wordArr.length; i++) {

            if (j == hackerrankArr.length) {
                break;
            }

            if (hackerrankArr[j] == wordArr[i]) {
                j++;
                contains++;
            }

        }

        if (contains == hackerrankArr.length) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args){

        System.out.println(hackerrankInString("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt"));

    }
}
