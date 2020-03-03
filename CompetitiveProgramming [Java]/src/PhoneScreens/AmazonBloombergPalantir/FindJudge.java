package PhoneScreens.AmazonBloombergPalantir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-23
 */
public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        //Directed graph
        //Town judge has no edge originating from it
        //Everybody is connected to the town judge
        //There is only one Town judge

        /*
         Create a map of Ni where the value is number of connections to it
         Create a set of possible jugdes:
         - A possible judge is someone that people have connected to
         and has not connected to anyone
         Loop over map, check for if value if Ni == N - 1 && if Ni is in set.
         if yes, return it.
         if no, return -1;
         */

        if (N == 1 && trust.length == 0)
            return 1;

        HashMap<Integer, Integer> connections = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            connections.putIfAbsent(i, 0);
        }

        HashSet<Integer> judges = new HashSet<>();
        HashSet<Integer> noJudges = new HashSet<>();
        for (int[] aTrust : trust) {
            connections.put(aTrust[1], connections.get(aTrust[1]) + 1);
            judges.add(aTrust[1]);
            noJudges.add(aTrust[0]);
        }

        for (Integer a : noJudges) {
            judges.remove(a);
        }

        for (Map.Entry<Integer, Integer> entry : connections.entrySet()) {
            if (entry.getValue() == N - 1 && judges.contains(entry.getKey())) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int findJudgeEff(int N, int[][] trust) {
        int[] judge = new int[N];

        for (int[] num : trust) {
            int a = num[0];
            int b = num[1];

            judge[a - 1] = -1;
            if (judge[b - 1] != -1) judge[b - 1]++;
        }

        for (int i = 0; i < judge.length; i++) {
            if (judge[i] == N - 1)
                return i + 1;
        }

        return -1;
    }
}
