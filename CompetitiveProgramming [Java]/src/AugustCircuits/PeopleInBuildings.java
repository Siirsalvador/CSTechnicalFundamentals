package AugustCircuits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-27
 */
public class PeopleInBuildings {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int citizenCount = scan.nextInt();
        int minPeople = scan.nextInt();

        List<People> peopleList = new ArrayList<>();

        for (int i = 1; i <= citizenCount; i++) {
            peopleList.add(new People(i, scan.nextInt(), scan.nextInt()));
        }
        int numberOfBuildings = peopleList.size() / minPeople;

        Collections.sort(peopleList);
        List<Building> buildings = populateBuilding(peopleList, numberOfBuildings, minPeople);

        System.out.println(buildings.size());
        for (Building aBuilding : buildings) {
            List<People> peopleList1 = aBuilding.getPeople();
            System.out.println(peopleList1.size());
            String result = peopleList1.stream().map(n -> String.valueOf(n.id))
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
    }

    private static List<Building> populateBuilding(List<People> peopleList, int numberOfBuildings, int minPeople) {

        List<Building> buildings = new ArrayList<>();

        int i = 0;
        int begIdx = 0;
        int endIdx = minPeople;

        Building aBuilding = new Building();
        while (i < numberOfBuildings) {

            if (i == numberOfBuildings - 1) endIdx = peopleList.size();
            aBuilding.addPeople(peopleList.subList(begIdx, endIdx));
            buildings.add(aBuilding);
            i++;

            if (i != numberOfBuildings - 1) {
                begIdx = endIdx;
                endIdx = endIdx + endIdx;
                aBuilding = new Building();
            }
        }

        return buildings;

    }

    static class People implements Comparable<People> {
        int id;
        int x;
        int y;

        People(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(People o) {
            int compare = this.x - o.x;
            return compare == 0 ? this.y - o.y : compare;
        }
    }

    static class Building {
        ArrayList<People> people = new ArrayList<>();

        Building() {
        }

        void addPerson(People o) {
            people.add(o);
        }

        void addPeople(List<People> people) {
            this.people.addAll(people);
        }

        ArrayList<People> getPeople() {
            return people;
        }
    }
}
