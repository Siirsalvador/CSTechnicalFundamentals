package DailyCodingProblem;

import java.util.Stack;

public class DCP27_BalancedBrackets {

    public static void main(String[] args) {

        String firstBracketCombo = "([])[]({[{}]})";
        String secondBracketCombo = "([)]";
        String thirdCombo = "{{)[](}}";
        String fourthCombo = "{(([])[])[]]}";

        System.out.println(areTheBracketsBalanced(firstBracketCombo));
        System.out.println(areTheBracketsBalanced(secondBracketCombo));
        System.out.println(areTheBracketsBalanced(thirdCombo));
        System.out.println(areTheBracketsBalanced(fourthCombo));
    }


    private static String areTheBracketsBalanced(String bracketCombos) {

        String startBrackets = "([{";
        boolean matchingResult = false;

        char[] bracketArr = bracketCombos.toCharArray();
        Stack<Character> bracketStack = new Stack<>();

        for (int i = 0; i < bracketArr.length; i++) {

            if (startBrackets.contains(String.valueOf(bracketArr[i]))) {

                bracketStack.push(bracketArr[i]);

            } else {

                if (bracketStack.empty()) {
                    return "NO";
                }

                char currentCharacter = bracketStack.pop();
                matchingResult = checkThatClosingAndOpeningBracketMatch(bracketArr[i], currentCharacter);

                if (!matchingResult)
                    return "NO";

            }
        }

        if (bracketStack.size() != 0) {
            return "NO";
        }
        return matchingResult ? "YES" : "NO";
    }

    private static boolean checkThatClosingAndOpeningBracketMatch(char c, char currentCharacter) {
        if (currentCharacter == '(') {
            return (c == ')');
        } else if (currentCharacter == '{') {
            return (c == '}');
        } else if (currentCharacter == '[') {
            return (c == ']');
        }

        return false;
    }
}
