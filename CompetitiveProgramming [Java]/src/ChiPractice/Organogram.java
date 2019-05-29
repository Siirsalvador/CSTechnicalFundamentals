package ChiPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A company's organizational structure is represented as
 * 1: 2, 3, 4
 * In the above employees with id 2, 3 and 4 report to 1
 * Assume the following hierarchy.
 * 1: 2, 3, 4
 * 3: 5, 6, 7
 * 5: 8, 9, 10
 * Given an employee Id, return all the employees reporting to him directly or
 * indirectly
 */

class OrganogramSolution {
    public static void main(String[] args) {

    }
}

public class Organogram {

    private Map<Integer, List<Integer>> employees = new HashMap<>();

    List<Integer> getCompleteTeam(Integer id) {

        // * 1: 2, 3, 4
        // * 3: 5, 6, 7
        // * 5: 8, 9, 10

        List<Integer> result = new ArrayList<>();
        List<Integer> team = employees.get(id); //[2 3 4]

        boolean remaining = true;

        while (remaining) {

            List<Integer> temp = new ArrayList<>(); //[ ]

            for (int person : team) { // [8 9 10]
                if (employees.containsKey(person)){
                    temp.addAll(employees.get(person));
                }
            }

            remaining = !temp.isEmpty(); // false
            result.addAll(team); // [ 2 3 4 5 6 7 8 9 10]
            team = temp;
        }

        return result;
    }
}
