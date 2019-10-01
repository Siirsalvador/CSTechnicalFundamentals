package Firecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-29
 */
public class CombParentheses {

/*
 Write a method to return all valid combinations of n-pairs of parentheses.

The method should return an ArrayList of strings, in which each string represents a valid combination of parentheses.

The order of the strings in the ArrayList does not matter.

Examples:
combParenthesis(2) ==> {"(())","()()"}

combParenthesis(3) ==> {"()(())", "(())()", "()()()", "((()))"}
Note: Valid combination means that parentheses pairs are not left open. ")()(" is not a valid combination.

1 => ()

ArrayList list = new ArrayList

String findParenth(int n){
if (n == 0) "";

//(())
"(".concat(findParenth(n-1)).concat(")");
"(".concat(")").concat(findParenth(n-1));
}

1. For each step, we need to select either a left or a right parenthesis.
2. Left: As long as we have not used up all the left parentheses, we can always insert a left parenthesis.
3. Right: We can insert a right parenthesis as long as it won’t lead to a syntax error. We will get a syntax error if there are more right parentheses than left.

*/

    static ArrayList<String> list = new ArrayList<>();

    static public void main(String args[]) {
        System.out.println(combParenthesis2(2));
    }

    private static ArrayList<String> combParenthesis(int pairs) {
        Set<String> combs = new HashSet<>();
        while (pairs > 0) {
            combs = new HashSet<>(generate(combs));
            pairs--;
        }
        return new ArrayList<>(combs);
    }

    private static ArrayList<String> generate(Set<String> strings) {
        ArrayList<String> newStrings = new ArrayList<>();
        if (strings.isEmpty()) {
            newStrings.add("()");
        } else {
            for (String s : strings) {
                newStrings.add("()" + s);
                newStrings.add("(" + s + ")");
                newStrings.add(s + "()");
            }
        }
        return newStrings;
    }

    private static ArrayList<String> combParenthesis2(int pairs) {

        ArrayList<String> tempList = new ArrayList<>();
        if (pairs == 0) return list;

        if (list.isEmpty()) {
            list.add("()");
        } else {
            for (String aStr : list) {
                tempList.add("()" + aStr);
                tempList.add(aStr + "()");
                tempList.add("(" + aStr + ")");
            }
            list = tempList;
        }

        return combParenthesis2(pairs - 1);
    }

    public static ArrayList<String> combParenthesis3(int pairs) {

        if(pairs <= 0) return new ArrayList<>();
        Set<String> brackList = new HashSet<>();
        brackList.add("()");

        if(pairs == 1) return new ArrayList<>(brackList);

        while(pairs-- > 1){
            Set<String> temp = new HashSet<>();
            for(String aBracket : brackList){
                temp.add("(".concat(aBracket).concat(")"));
                temp.add("()".concat(aBracket));
                temp.add(aBracket.concat("()"));
            }
            brackList = temp;
        }

        return new ArrayList<>(brackList);
    }
}
