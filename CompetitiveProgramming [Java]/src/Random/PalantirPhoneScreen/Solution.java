package Random.PalantirPhoneScreen;

import java.util.*;

public class Solution {
    Map<String, List<String>> userGroups;

    /**
     * Group 1: [A, B, C, Group 3]
     * Group 2: [D, E]
     * Group 3: [G]
     */
    Solution(Map<String, List<String>> ug) {
        this.userGroups = ug;
    }

    private static HashSet<String> getUserForGroups(Map<String, List<String>> mapOfUsers, String groupName) {
        HashSet<String> hashSetOfUser = new HashSet<>();

        List<String> valuesFromKey = mapOfUsers.get(groupName);
        for (int i = 0; i < valuesFromKey.size(); i++) {
            if (mapOfUsers.containsKey(valuesFromKey.get(i))) {
                valuesFromKey.addAll(mapOfUsers.get(valuesFromKey.get(i)));
            } else {
                hashSetOfUser.add(valuesFromKey.get(i));
            }
        }

        return hashSetOfUser;
    }

    private static boolean isUserInGroup(Map<String, List<String>> mapOfUsers, String groupName, String user) {
        HashSet<String> usersInGroup = getUserForGroups(mapOfUsers, groupName);
        return usersInGroup.contains(user);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ayomide");
        list.add("Okpetere");
        list.add("group2");

        List<String> secondList = new ArrayList<>();
        secondList.add("group3");

        List<String> thirdList = new ArrayList<>();
        thirdList.add("Oyekanmi-Sagay");

        Map<String, List<String>> mapOfUsers = new HashMap<>();
        mapOfUsers.put("group1", list);
        mapOfUsers.put("group2", secondList);
        mapOfUsers.put("group3", thirdList);

        System.out.println(getUserForGroups(mapOfUsers, "group1"));
        System.out.println(isUserInGroup(mapOfUsers, "group1", "Ayomide"));

    }
}
