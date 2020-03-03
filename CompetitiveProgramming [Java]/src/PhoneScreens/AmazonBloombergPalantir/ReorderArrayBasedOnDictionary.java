package PhoneScreens.AmazonBloombergPalantir;

import javafx.util.Pair;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class ReorderArrayBasedOnDictionary {

    static HashMap<String, Integer> roleToLevel;

    public static void main(String[] args) {


        System.out.println("A".compareTo("B"));

        roleToLevel = new HashMap<>();
//        roleToLevel.put("CEO", 1);
//        roleToLevel.put("CFO", 2);
//        roleToLevel.put("CTO", 3);
//        roleToLevel.put("Manager", 4);
//        roleToLevel.put("Engineer", 5);

        String[][] reporting = {{"CTO", "CEO"}, {"Manager", "CTO"}, {"Engineer", "Manager"}, {"CFO", "CEO"}};
        createRoleToLevelMap(reporting, "CEO");

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Manager"));
        employees.add(new Employee("Sally", "CTO"));
        employees.add(new Employee("Sam", "CEO"));
        employees.add(new Employee("Drax", "Engineer"));
        employees.add(new Employee("Bob", "CFO"));
        employees.add(new Employee("Daniel", "Engineer"));

        System.out.println(reorderBasedOnRoles(employees));
    }

    private static void createRoleToLevelMap(String[][] reporting, String role) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] str : reporting) {
            map.putIfAbsent(str[0], new ArrayList<>());
            map.putIfAbsent(str[1], new ArrayList<>());
            map.get(str[1]).add(str[0]);
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(role, 1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> currRole = queue.poll();
            roleToLevel.putIfAbsent(currRole.getKey(), currRole.getValue());

            ArrayList<String> subs = map.get(currRole.getKey());
            for (String sub : subs) {
                queue.add(new Pair<>(sub, currRole.getValue() + 1));
            }
        }
    }

    public static ArrayList<Employee> reorderBasedOnRoles(ArrayList<Employee> list) {
        Collections.sort(list);
        return list;
    }

    static class Employee implements Comparable<Employee> {
        String name;
        String role;

        Employee(String name, String role) {
            this.name = name;
            this.role = role;
        }

        public int compareTo(Employee o) {
            return roleToLevel.get(this.role) - roleToLevel.get(o.role);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }
}

