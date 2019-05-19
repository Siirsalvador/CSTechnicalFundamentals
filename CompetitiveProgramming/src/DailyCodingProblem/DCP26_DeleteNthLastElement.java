package DailyCodingProblem;

import java.util.Arrays;
import java.util.LinkedList;

public class DCP26_DeleteNthLastElement {

    private static void deleteNthLastElement(int n, LinkedList linkedList) {
//        int length = linkedList.size();
//        int index = (length - 1) - n;

        int iterativeCounter = 0;
        int nthCounter = n;

        for (int i = 0; i <= n; i++) {
            if (nthCounter != 0) {
                iterativeCounter++;
                nthCounter--;
            } else {
                break;
            }
        }

        linkedList.remove(iterativeCounter);
    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(250);
        linkedList.add(100);
        linkedList.add(120);
        linkedList.add(200);
        linkedList.add(500);
        linkedList.add(1000);
        linkedList.add(150);

        System.out.println(Arrays.toString(linkedList.toArray()));

        DCP26_DeleteNthLastElement.deleteNthLastElement(3, linkedList);

        System.out.println(Arrays.toString(linkedList.toArray()));

    }
}
