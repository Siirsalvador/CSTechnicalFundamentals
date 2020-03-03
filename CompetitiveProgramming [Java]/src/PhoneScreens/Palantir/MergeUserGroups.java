package PhoneScreens.Palantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-21
 */
public class MergeUserGroups {

    public static void main(String[] args) {
        List<List<String>> users = new ArrayList<>();
        users.add(Arrays.asList("1", "1.0.0.1", "a@o.com"));
        users.add(Arrays.asList("2", "1.0.0.1", "e@o.com"));
        users.add(Arrays.asList("3", "1.2.3.4", "a@o.com"));
        users.add(Arrays.asList("4", "1.5.6.3", "b@c.com"));
        users.add(Arrays.asList("5", "1.5.6.3", "e@o.com"));

        System.out.println(groupAllUsers(users));
    }

    public static String groupAllUsers(List<List<String>> users) {
        Map<String, String> emailToId = new HashMap<>();
        Map<String, String> ipToId = new HashMap<>();
        Map<String, Set<List<String>>> userToGroups = new HashMap<>();

        for (List<String> user : users) {

            String id = user.get(0);
            String ip = user.get(1);
            String email = user.get(2);

            if (emailToId.containsKey(email) && ipToId.containsKey(ip) && !emailToId.get(email).equals(ipToId.get(ip))) {
                mergeGroups(email, ip, emailToId, ipToId, userToGroups);
                continue;
            }

            if (emailToId.containsKey(email)) {
                ipToId.put(ip, emailToId.get(email));
                userToGroups.get(emailToId.get(email)).add(user);
                continue;
            }

            if (ipToId.containsKey(ip)) {
                emailToId.put(email, ipToId.get(ip));
                userToGroups.get(ipToId.get(ip)).add(user);
                continue;
            }

            emailToId.putIfAbsent(email, id);
            ipToId.putIfAbsent(ip, id);
            userToGroups.putIfAbsent(id, new HashSet<>());
            userToGroups.get(id).add(user);
        }

        return String.valueOf(userToGroups.entrySet());

    }

    private static void mergeGroups(String email, String ip, Map<String, String> emailToId, Map<String, String> ipToId, Map<String, Set<List<String>>> userToGroups) {

        String emailId = emailToId.get(email);
        String ipId = ipToId.get(ip);

        Set<List<String>> ipUsers = userToGroups.get(ipId);
        for (List<String> entry : ipUsers) {
            emailToId.put(entry.get(2), emailId);
            ipToId.put(entry.get(1), emailId);
        }

        userToGroups.remove(ipId);
        userToGroups.get(emailId).addAll(ipUsers);
    }
}
