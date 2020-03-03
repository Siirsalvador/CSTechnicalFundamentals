package PhoneScreens.Amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-07
 */
public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String[] o1Arr = o1.split(" ", 2);
                String[] o2Arr = o2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(o1Arr[1].charAt(0));
                boolean isDigit2 = Character.isDigit(o2Arr[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int diff = o1Arr[1].compareTo(o2Arr[1]);
                    return diff == 0 ? o1Arr[0].compareTo(o2Arr[0]) : diff;
                }

                // gb 6
                if (!isDigit1) {
                    return -1;
                }

                // 3 ag
                if (!isDigit2) {
                    return 1;
                }

                return 0;
            }
        });


        /*
            //Ascending
            Comparator(Obj1, Obj2)

            -1 Obj1 < Obj2
            1 Obj1 > Obj2
            0 Obj1 = Obj2
         */

        return logs;
    }
}
