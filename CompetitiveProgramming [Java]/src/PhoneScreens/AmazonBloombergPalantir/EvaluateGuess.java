package PhoneScreens.AmazonBloombergPalantir;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-22
 */
public class EvaluateGuess {

    static String correctStr = "ABCFFDE";
    /**

     ABCFFDE


     ABCDEDY (4,0)
     */
  /*
   Build a charToFreq HashMap for original string
   Declare correctPos and present variables.
   Loop over given string
   - Check if character is in right position, if yes increment correctPos by 1. Decrease char freq in map

   Loop over given string
    - Check if character is in hashmap, if yes increment present by 1. Decrease char freq in map
    - if no, continue

  int{correctPos, present}
  */

    public static int[] evaluateGuess(String givenStr){
        int correctPos = 0;
        int present = 0;

        HashMap<Character, Integer> charToFreq = new HashMap<>();
        for(int i = 0; i < correctStr.length(); i++){
            char currChar = correctStr.charAt(i);
            charToFreq.putIfAbsent(currChar, 0);
            charToFreq.put(currChar, charToFreq.get(currChar) + 1);
        }

        for(int i = 0; i < givenStr.length(); i++){
            char currChar = correctStr.charAt(i);
            if(correctStr.charAt(i) == givenStr.charAt(i)){
                correctPos++;
                charToFreq.put(currChar, charToFreq.get(currChar) - 1);
            }
        }

        for(int i = 0; i < givenStr.length(); i++){
            char curr = givenStr.charAt(i);
            if(correctStr.charAt(i) != curr && charToFreq.containsKey(curr) && charToFreq.get(curr) > 0){
                present++;
                charToFreq.put(curr, charToFreq.get(curr) - 1);
            }
        }

        return new int[]{correctPos, present};
    }

    static public void main( String args[] ) {
        System.out.println(Arrays.toString(evaluateGuess("ABCDEDY")));
    }
}
