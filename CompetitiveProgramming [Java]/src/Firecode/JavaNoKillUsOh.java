package Firecode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class JavaNoKillUsOh {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date date = dateFormat.parse("10-OCT-2019 18:16:55");
        Date date1 = new Date();
        System.out.println(date1.toInstant().getEpochSecond());

        List<String> strings = new ArrayList<>();
        strings.add("Hi");
        strings.add("Hello");

        String[] strings1 = strings.toArray(new String[0]);
        System.out.println(Arrays.toString(strings1));

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 8},
                {9, 7, 0}
        };

        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 8},
                {9, 7, 0}
        };

    }
}
