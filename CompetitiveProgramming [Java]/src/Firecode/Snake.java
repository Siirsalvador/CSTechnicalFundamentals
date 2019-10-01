package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class Snake {

    public static ArrayList<Integer> findSpiral(int[][] arr) {

        int cStart = 0;
        int cEnd = arr[0].length - 1; //columns

        int rStart = 0;
        int rEnd = arr.length - 1; //rows

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {

            //Left to Right
            for (int i = cStart; i <= cEnd; i++)
                list.add(arr[rStart][i]);

            rStart++;
            if(cStart > cEnd || rStart > rEnd) break;

            //Top to Bottom
            for (int i = rStart; i <= rEnd; i++)
                list.add(arr[i][cEnd]);

            cEnd--;
            if(cStart > cEnd || rStart > rEnd) break;

            //Right to Left
            for (int i = cEnd; i >= cStart; i--)
                list.add(arr[rEnd][i]);

            rEnd--;
            if(cStart > cEnd || rStart > rEnd) break;

            //Bottom to Top
            for (int i = rEnd; i >= rStart; i--)
                list.add(arr[i][cStart]);

            cStart++;
            if(cStart > cEnd || rStart > rEnd) break;

        }

        return list;
    }
}

