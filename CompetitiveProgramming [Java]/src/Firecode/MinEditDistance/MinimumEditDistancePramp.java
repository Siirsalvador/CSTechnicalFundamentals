package Firecode.MinEditDistance;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-25
 */

/*
Edit distance is a classic algorithm that is used in many applications, including Spell Correction, DNA Sequencing and Natural Language Processing. Given two Strings, a and b, write a method - editDistance that returns the minimum number of operations needed to transform a into b. The following character operations are allowed :

a) Replace character
b) Insert character
c) Delete character

Examples :

editDistance("sale", "sales") => 1

Operations :
1) Insert "s"

editDistance("sale", "sold") => 2

Operations :
1) Replace "a" with "o"
2) Replace "e" with "d"

editDistance("sa", "s") => 1

Operations :
1) Delete "a"


SALE SALE  (0)
SALE SALES (b-a)
""   ANY   (ANY.length)


SOLD

SALEOP

SALE

  " S A L E S
" 0 1 2 3 4 5
S 1 0 1 2 3 4
A 2 1 0 1 2 3
L 3 2 1 0 1 2
E 4 3 2 1 0 1


*/

public class MinimumEditDistancePramp {

    public static void main(String args[]) {
        int res = editDistance("SALE", "SALES");
        System.out.println(res);
//        int res = editDistance("FAVOUR", "FLAVOUR");
//        System.out.println(res);
    /*res = editDistance("ENJOY", "FLENJO");
    System.out.println(res);
    res = editDistance("SALE", "SOLD");
    System.out.println(res); */
    }

    //sorry data finished
    static int editDistance(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return -1;
        }

        if(s1 == s2 || s1.equals(s2)) {
            return 0;
        }

        if(s2.contains(s1)) {
            return s2.length() - s1.length();
        }

        if("".equals(s1)) {
            return s2.length();
        }

        int[][] table = new int[s2.length() + 1][s1.length() + 1];
        for (int i = 0; i < table.length; i++) { //rows
            table[i][0] = i;
        }

        for (int i = 0; i < table[0].length; i++) {
            table[0][i] = i;
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    int min = Math.min(Math.min(table[i - 1][j - 1], table[i - 1][j]), table[i][j - 1]);
                    table[i][j] = min + 1;
                }
            }
        }

        //ayoSaidWeShouldCallItMethod(table, s2, s1);
        printActualEdits(table, s1, s2);
        return table[s2.length()][s1.length()];
    }


    static void ayoSaidWeShouldCallItMethod(int[][] table, String s1, String s2) {

        int rows = table.length;
        int cols = table[0].length;

        int r = rows - 1;
        int c = cols - 1;

        while (r > 0 && c > 0) {

            if (s2.charAt(r - 1) == s1.charAt(c - 1)) {
                r = r - 1;
                c = c - 1;
                continue;
            }

            //left
            if (table[r][c] == table[r - 1][c] + 1) {
                System.out.println("Deleted " + s2.charAt(r - 1));
                r = r - 1;
                continue;
            }

            //top
            if (table[r][c] == table[r][c - 1] + 1) {
                System.out.println("Added " + s1.charAt(c - 1) + " to " + s2);
                c = c - 1;
                continue;
            }

            //diag
            if (table[r][c] == table[r - 1][c - 1] + 1) {
                System.out.println("Changed " + s1.charAt(c - 1) + " to " + s2.charAt(r - 1));
                r = r - 1;
                c = c - 1;
            }
        }

    }

    public static void printActualEdits(int T[][], String str2, String str1) {
        int i = T.length - 1;
        int j = T[0].length - 1;

        while (i != 0 && j != 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j - 1] + 1) {
                System.out.println("Edit " + str2.charAt(j - 1) + " in string2 to " + str1.charAt(i - 1) + " in string1");
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j] + 1) {
                System.out.println("Delete in string1 " + str1.charAt(i - 1));
                i = i - 1;
            } else if (T[i][j] == T[i][j - 1] + 1) {
                System.out.println("Delete in string2 " + str2.charAt(j - 1));
                j = j - 1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }


}

















