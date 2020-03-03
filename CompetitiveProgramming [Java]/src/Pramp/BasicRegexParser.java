package Pramp;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-20
 */
public class BasicRegexParser {

    static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    static boolean isMatchUnefficient(String text, String pattern) {
        return isMatchHelper(text, pattern, 0, 0);
    }

    private static boolean isMatchHelper(String text, String pattern, int textIdx, int patIdx) {
        if (textIdx >= text.length()) {
            //if patternIdx is also at last index
            if (patIdx >= pattern.length()) {
                  return true;
            } else if (patIdx + 1 < pattern.length() && pattern.charAt(patIdx + 1) == '*') {
                return isMatchHelper(text, pattern, textIdx, patIdx + 2);
            } else return false;

        } else if (patIdx >= pattern.length()) {
            return false;
        } else if (patIdx + 1 < pattern.length() && pattern.charAt(patIdx + 1) == '*') {
            if (pattern.charAt(patIdx) == '.' || pattern.charAt(patIdx) == text.charAt(textIdx)) {
                return isMatchHelper(text, pattern, textIdx, patIdx + 2) ||
                        isMatchHelper(text, pattern, textIdx + 1, patIdx);
            } else {
                isMatchHelper(text, pattern, textIdx, patIdx + 2);
            }
        } else if (pattern.charAt(patIdx) == '.' || pattern.charAt(patIdx) == text.charAt(textIdx)) {
            return isMatchHelper(text, pattern, textIdx + 1, patIdx + 1);
        }

        return false;
    }

    public static void main(String[] args) {

        String text = "acd";
        String pattern = "ab*c.";

        System.out.println(isMatch(text, pattern));
    }

}


// if i + 1 == "*"

// else if i = "."

// else compare pattern at i and text at i


//b*c -> bbbbbbbc, c
//.b.c -> dbac

// if pattern doesn't contain . and * then return pattern.equals(text)
// if contains . iterate over the string check if chars match or if .
// if a*, continue
// *. .* -> aaaaaaaa, bbbb, z, " "

/*

function isMatch(text, pattern):
    return isMatchHelper(text, pattern, 0, 0)


#  Input:
#    text - the text to check,
#    pattern - the regular expression to be checked,
#    textIndex - the index the text is checked from
#    patIndex -  the index the pattern is checked from
#  Output:
#   true if the text from the index textIndex matches
#   the regular expression pattern from the pattern Index.
#   E.g. isMatchHelper(“aaabb”,”cab*”,2, 1) since the text
#   from index 2 (“abb”) matches the pattern from index 1 (“ab*”)

function isMatchHelper(text, pattern, textIndex, patIndex):
    # base cases - one of the indexes reached the end of text or pattern
    if (textIndex >= text.length):
        if (patIndex >= pattern.length):
            return true
        else:
            if (patIndex+1 < pattern.length) AND  (pattern[patIndex+1] == '*'):
                return isMatchHelper(text, pattern, textIndex, patIndex + 2)
            else:
                return false

    else if (patIndex >= pattern.length) AND (textIndex < text.length):
        return false

    # string matching for character followed by '*'
    else if (patIndex+1 < pattern.length) AND (pattern[patIndex+1] == '*'):
        if (pattern[patIndex] == '.') OR (text[textIndex] == pattern[patIndex]):
            return (isMatchHelper(text, pattern, textIndex, patIndex + 2) OR
                    isMatchHelper(text, pattern, textIndex + 1, patIndex))
        else:
            return isMatchHelper(text, pattern, textIndex, patIndex + 2)

    # string matching for '.' or ordinary char.
    else if (pattern[patIndex] == '.') OR
            (pattern[patIndex] == text[textIndex]):
        return  isMatchHelper(text, pattern, textIndex + 1, patIndex + 1)
    else:
        return false
 */