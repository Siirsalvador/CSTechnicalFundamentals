package PhoneScreens.Facebook;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-14
 */
public class AccountMerge {

    public static void main(String[] args) {
        String[][] accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};

        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(String[][] accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.length == 0) return result;

        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] account : accounts) {
            for (int i = 1; i < account.length; i++) {
                graph.putIfAbsent(account[i], new HashSet<>());
                graph.get(account[i]).add(account[1]);
                graph.get(account[1]).add(account[i]);
            }
        }
        //O(E)

        System.out.println(graph.entrySet());

        Set<String> visited = new HashSet<>();
        for (String[] account : accounts) {
            if (!visited.contains(account[1])) {
                List<String> mergedEmails = new ArrayList<>();
                dfs(graph, visited, mergedEmails, account[1]);
                Collections.sort(mergedEmails);
                mergedEmails.add(0, account[0]);
                result.add(mergedEmails);
            }
        }
        //O(V)

        return result; //O(V + E)
    }

    private static void dfs(Map<String, Set<String>> graph, Set<String> visited, List<String> mergedEmails, String email) {
        mergedEmails.add(email);
        visited.add(email);
        for (String nextEmail : graph.get(email)) {
            if (!visited.contains(nextEmail)) {
                dfs(graph, visited, mergedEmails, nextEmail);
            }
        }
    }
}
