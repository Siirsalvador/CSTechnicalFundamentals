package ChiPractice.LP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crossword {

    private static Map<String, Space> findMatchingWordVertically(char[][] grid, List<String> words, int[] intersect) {

        int row = intersect[0];
        int col = intersect[1];
        int searchIdx = 0;
        char searchChar = grid[row][col];

        int wordLength = 0;
        Space space = new Space();

        //INTERSECT IS STARTING POINT
        if (row == 0 || grid[row - 1][col] != '-') { //we're on first row or space above != '-'
            space.start = new int[]{row, col};

            while (true) {
                if (row >= grid.length || grid[row][col] != '-' || !Character.isAlphabetic(grid[row][col])) {
                    break;
                }
                wordLength++;
                row++;
            }
            space.end = new int[]{row - 1, col};

        } //INTERSECT IS ENDING POINT
        else if (row == grid.length - 1 || grid[row + 1][col] != '-') {
            space.end = new int[]{row, col};
            while (true) {
                if (row >= grid.length || (grid[row][col] != '-' && !Character.isAlphabetic(grid[row][col]))) {
                    break;
                }
                row--;
                wordLength++;
            }
            searchIdx = wordLength - 1;
            space.start = new int[]{row + 1, col};

        } //INTERSECT IS IN MIDDLE
        else {
            while (true) {
                if (row == 0 || (grid[row][col] != '-' && !Character.isAlphabetic(grid[col][row]))) {
                    break;
                }
                row--;
            }
            space.start = new int[]{row, col}; //1,2
            while (true) {
                if (row >= grid.length || (grid[row][col] != '-' && !Character.isAlphabetic(grid[row][col]))) {
                    break;
                }
                if (Character.isAlphabetic(grid[row][col])) {
                    searchIdx = row - space.start[0];
                }
                wordLength++;
                row++;
            }
            space.end = new int[]{row - 1, col};
        }

        String match = findWordInList(searchChar, searchIdx, wordLength, words);

        space.length = wordLength;
        Map<String, Space> spaceMap = new HashMap<>();
        spaceMap.put(match, space);
        return spaceMap;
    }

    private static String findWordInList(char searchChar, int searchIdx, int wordLength, List<String> words) {
        for (String word : words) {
            if (word.charAt(searchIdx) == searchChar && word.length() == wordLength) {
                return word;
            }
        }
        return "";
    }

    static class Space{
        int[] start;
        int [] end;
        int length;
    }

}