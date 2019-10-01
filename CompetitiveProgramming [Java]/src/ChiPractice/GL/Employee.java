package ChiPractice.GL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-27
 */

//Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.
//
//        1. Company hierarchy / organisation
//        At the top is CEO (Employee)
//        CEO has direct reports (Employees)
//        Reports have more direct reports
//        etc.

class Employee {
    String name;
    Employee manager;  // can be null for CEO
    List<Employee> reports = new ArrayList<>();  // can be empty for entry-level people

    public Employee(String name) {
        this.name = name;
    }

    ;

    public void addReport(Employee report) {
        this.reports.add(report);
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}

class Rel {  // Relationship
    String manager;   // "Joel"
    String report;    // "Andrew"

    //        [
    //        manager="Joel", report="Andrew",
    //        "Katie", "Alice",
    //        "Katie", "Bob"
    //        "Katie", "Joel",
    //        ]

    // create all the employee objects
    // return the CEO

    // Joel -> Andrew
    // Katie -> Alice, Joel
    Employee buildHierarchyAndReturnCEO(List<Rel> rels) {
        // your code here
        if (rels == null) return null;

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Rel rel : rels) {

            Employee manager = getOrAddEmployee(rel.manager, employeeMap);
            Employee report = getOrAddEmployee(rel.report, employeeMap);

            manager.addReport(report);
            report.setManager(manager);
        }

        for (Employee employee : employeeMap.values()) {
            if (employee.manager == null) {
                return employee;
            }
        }

        return null;
    }

    Employee getOrAddEmployee(String mgrName, Map<String, Employee> employeeMap) {
        if (employeeMap.containsKey(mgrName)) {
            return employeeMap.get(mgrName);
        }

        return new Employee(mgrName);
    }
}
