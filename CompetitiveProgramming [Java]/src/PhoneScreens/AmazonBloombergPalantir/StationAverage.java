package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-26
 */
class StationAverage {

    HashMap<String, ArrayList<Double>> timeDiffs = new HashMap<>();
    HashMap<Integer, ArrayList<String>> userLocation = new HashMap<>();

    public void swipeIn(int id, String dest, Double time) {
        userLocation.putIfAbsent(id, new ArrayList<>());
        userLocation.get(id).add(0, dest);
        userLocation.get(id).add(1, String.valueOf(time));
    }

    public void swipeOut(int id, String dest, Double time) {
        ArrayList<String> info = userLocation.get(id);
        Double prevTime = Double.parseDouble(info.get(1));
        String prevDest = info.get(0);

        String key = prevDest + ":" + dest;
        timeDiffs.putIfAbsent(key, new ArrayList<>());
        timeDiffs.get(key).add(time - prevTime);
    }

    //Lagos : Abuja
    //Abuja : Lagos
    public Double getAvgTime(String dest1, String dest2) {
        String key = dest1 + ":" + dest2;

        if (!timeDiffs.containsKey(key)) return 0.0;// throw exception or return 0.0

        ArrayList<Double> times = timeDiffs.get(key);

        Double total = 0.0;
        for (Double time : times) {
            total += time;
        }

        return total / times.size();
    }

}
