package ChiPractice.GS;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class SampleStack {

    private int min;
    private ArrayList<Integer> arrayList;
    private ArrayList<Integer> minList;

    SampleStack() {
        this.min = Integer.MAX_VALUE;
        this.arrayList = new ArrayList<>();
        this.minList = new ArrayList<>();
    }

    void push(int num) {

        if (num <= min) {
            min = num;
            minList.add(min);
        }

        arrayList.add(num);
    }

    int pop() {

        int num = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);

        if (num == min) {
            minList.remove(minList.size() - 1);
        }

        return num;
    }

    int getMin() {
        return minList.size() - 1;
    }
}
