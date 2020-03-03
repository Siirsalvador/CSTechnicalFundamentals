package PhoneScreens.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-04
 */
public class ChangeStates {

    public static void main(String[] args) {
        int[] states = {1, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(cellCompete(states, 1));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days) {
        if (states == null || states.length == 0 || days < 0)
            return new ArrayList<>();

        /*
        loop over days
        changeStates

        get a copy of states array.
        for each idx, change state accordingly.

        return state after number of days.

        */
        for (int i = 0; i < days; i++) {
            changeStates(states);
        }

        List<Integer> result = new ArrayList<>();
        for (int state : states) {
            result.add(state);
        }
        return result;
    }

    private static void changeStates(int[] states) {

        int[] temp = new int[states.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = states[i];
        }

        for (int i = 0; i < states.length; i++) {
            int prev = i == 0 ? 0 : temp[i - 1];
            int next = i + 1 == temp.length ? 0 : temp[i + 1];
            states[i] = prev == next ? 0 : 1;
        }
    }
}
