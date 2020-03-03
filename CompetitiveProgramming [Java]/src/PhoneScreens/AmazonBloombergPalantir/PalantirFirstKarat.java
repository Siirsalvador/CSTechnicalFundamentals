package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-27
 */
public class PalantirFirstKarat {

    /*
We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each list should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

badge_records_1 = [
  ["Martha",   "exit"],
  ["Paul",     "enter"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Paul",     "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Paul",     "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Paul",     "enter"],
  ["Paul",     "enter"],
  ["Martha",   "exit"],
]

Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]

Additional test cases:

badge_records_2 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], []

badge_records_3 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: [], ["Paul"]

badge_records_4 = [
  ["Paul", "exit"],
  ["Paul", "enter"],
  ["Martha", "enter"],
  ["Martha", "exit"],
]

Expected output: ["Paul"], ["Paul"]

badge_records_5 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

n: length of the badge records array



*/
    public static void main(String[] argv) {
        String badgeRecords1[][] = new String[][]{
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
        };

        String badgeRecords2[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        String badgeRecords3[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        String badgeRecords4[][] = new String[][]{
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Martha", "exit"},
        };

        String badgeRecords5[][] = new String[][]{
                {"Paul", "enter"},
                {"Paul", "exit"},
        };


        System.out.println(evaluateEmployeeActions(badgeRecords1));
        System.out.println(evaluateEmployeeActions(badgeRecords2));
        System.out.println(evaluateEmployeeActions(badgeRecords3));
        System.out.println(evaluateEmployeeActions(badgeRecords4));
        System.out.println(evaluateEmployeeActions(badgeRecords5));

    }

    public static ArrayList<ArrayList<String>> evaluateEmployeeActions(String[][] employees) {

        Set<String> noMatchingEntry = new HashSet<>();
        Set<String> noMatchingExit = new HashSet<>();
        HashMap<String, String> empToAction = new HashMap<>();

        int idx = 0;
        while (idx < employees.length) {

            if (empToAction.get(employees[idx][0]).equals("enter") && !employees[idx][1].equals("exit")) {
                noMatchingExit.add(employees[idx][0]);
            } else if (empToAction.get(employees[idx][0]).equals("exit") && !employees[idx][1].equals("enter")) {
                noMatchingEntry.add(employees[idx][0]);
            } else if (employees[idx][1].equals("exit") && !empToAction.containsKey(employees[idx][0])) {
                noMatchingEntry.add(employees[idx][0]);
            }

            empToAction.put(employees[idx][0], employees[idx][1]);
            idx++;
        }

        for (Map.Entry<String, String> entry : empToAction.entrySet()) {
            if (!entry.getValue().equals("exit")) {
                noMatchingExit.add(entry.getKey());
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result.add(new ArrayList<>(noMatchingExit));
        result.add(new ArrayList<>(noMatchingEntry));

        return result;
    }
}


