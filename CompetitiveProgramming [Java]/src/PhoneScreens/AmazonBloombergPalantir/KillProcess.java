package PhoneScreens.AmazonBloombergPalantir;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-19
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        List<Integer> result = new ArrayList<>();
        if(ppid == null || ppid.size() == 0) return result;
        if(pid == null || pid.size() == 0 || pid.size() != ppid.size()) return result;
        //parentToChildrenIds
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);
            if(!map.containsKey(curr)) continue;

            List<Integer> cpids = map.get(curr);
            for(Integer c : cpids){
                queue.add(c);
            }
        }

        return result;
    }
}
