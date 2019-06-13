package Hackerrank.InterviewPrepKit.Recursion;

/*
 * https://www.hackerrank.com/challenges/crossword-puzzle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */

/*

++++++++++     ++++++++++
+------+++     +POLAND+++
+++-++++++     +++H++++++
+++-++++++     +++A++++++
+++-----++     +++SPAIN++
+++-++-+++     +++A++N+++
++++++-+++     ++++++D+++
++++++-+++     ++++++I+++
++++++-+++     ++++++A+++
++++++++++     ++++++++++

POLAND;LHASA;SPAIN;INDIA

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Crossword {

    static Map<Integer, Map<Integer, List<Space>>> findHorizontalSpaces(String[] crossword) {

        //Map of Lengths to List of Spaces
        Map<Integer, List<Space>> horizontalMap = new HashMap<>();

        //Map of rows to List of Spaces
        Map<Integer, Map<Integer, List<Space>>> rowMap = new HashMap<>();

        //Horizontal Spaces
        for (int i = 0; i < crossword.length; i++) {

            char[] eachRow = crossword[i].toCharArray();

            Space freeSpace = null;

            for (int j = 0; j < eachRow.length; j++) {

                if (eachRow[j] == '-' && freeSpace != null) {

                    //If we find a freespace, and it is right after another freespace
                    freeSpace.length++;

                }

                if (eachRow[j] == '-' && freeSpace == null) {

                    //If this is the first freespace we find in a row
                    //Or the first free space after a '+'
                    freeSpace = new Space();
                    freeSpace.start = new int[i][j];
                    freeSpace.length++;

                }

                if (eachRow[j] == '+' && freeSpace != null) {

                    //If we find a '+' and there have been freespaces before it

                    if (freeSpace.length > 1) {

                        if (horizontalMap.containsKey(freeSpace.length)) {
                            freeSpace.end = new int[i][j];
                            horizontalMap.get(freeSpace.length).add(freeSpace);

                        }

                        if (!horizontalMap.containsKey(freeSpace.length)) {

                            freeSpace.end = new int[i][j];

                            List<Space> spaces = new ArrayList<>();
                            spaces.add(freeSpace);

                            horizontalMap.put(freeSpace.length, spaces);
                        }
                    }

                }

                if (eachRow[j] == '+' && freeSpace == null) {

                    //If we just found a '+' and there has been no freespace

                }

            }

            rowMap.put(i, horizontalMap);
            horizontalMap = new HashMap<>();

        }

        return rowMap;
    }

    static void findVerticalSpaces(String[] crossword) {

        //Map of Rows to List of Spaces
        Map<Integer, List<Space>> verticalMap = new HashMap<>();

        //Map of columns to List of Spaces
        Map<Integer, Map<Integer, List<Space>>> columnMap = new HashMap<>();

        //Vertical Spaces
        for (int i = 0; i < crossword.length; i++) {

            char[] eachRow = crossword[i].toCharArray();

            int length = 0;

            for (int j = 0; j < eachRow.length; j++) {

                if (eachRow[i] == '-' && length == 1) {
                    length = 0;
                }

                if (eachRow[i] == '-' && length == 0) {
                    length++;
                }

                if (eachRow[i] == '+' && length == 1) {
//                    columnMap.get(j).get(j).contains("")
                }

            }
        }


    }


    static String[] crosswordPuzzle(String[] crossword, String words) {

        return new String[1];

    }


    public static void main(String[] args) {

    }


    static class Space {
        int[][] start;
        int[][] end;
        int length = 0;

        Space(int[][] start, int[][] end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        Space() {
        }
    }
}
