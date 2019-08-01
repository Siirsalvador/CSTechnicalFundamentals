package ChiPractice.GS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class LinkedListIntersection {

    public ArrayList getIntersection(LinkedList<String> listA, LinkedList<String> listB) {

        //Assuming no duplications
        Set<String> visitedByListA = new HashSet<>();
        visitedByListA.addAll(listA);

        ArrayList<String> intersection = new ArrayList<>();
        for (String s : listB) {
            if (visitedByListA.contains(s)) {
                intersection.add(s);
            }
        }

        return intersection;
    }
}
