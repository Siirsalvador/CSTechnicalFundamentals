package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-06
 */
public class CombinationsAndPermutations {

    public static ArrayList<String> getCombPerms(String s) {
        if(s == null) return null;

        ArrayList<String> result = new ArrayList<>();
        if(s.isEmpty() || s.length() == 1) {
            result.add(s);
            return result;
        }

        result.add("");

        for(char aChar : s.toCharArray()){
            ArrayList<String> tempList = new ArrayList<>();
            for(String aStr : result){
                for(int i = 0; i <= aStr.length(); i++){
                    tempList.add(aStr.substring(0, i) + aChar + aStr.substring(i));
                }
            }
            result.addAll(tempList);
        }

        result.remove(0);
        return result;
    }

    public static void main(String[] args){
        String s = "ab";
        System.out.println(getCombPerms(s));
    }
}
