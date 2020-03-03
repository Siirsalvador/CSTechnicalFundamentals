package PhoneScreens.AmazonBloombergPalantir;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-01
 */
public class OutputStreamInOrder {

    Queue<StreamData> queue = new PriorityQueue<>();
    private int min = 1;

    public void outputStreamInOrder(Map<Integer, String> entries) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Map.Entry<Integer, String> entry : entries.entrySet()) {
            if (entry.getKey() == min) {
                System.out.println(entry);
                min++;
            } else {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty() && queue.peek() == min) {
            System.out.println("[" + min + ", " + entries.get(min) + "]");
            queue.poll();
            min++;
        }
    }

    public void outputStreamInOrder(StreamData data) {
        queue.offer(data);

        while (!queue.isEmpty() && queue.peek().pos == min++) {
            System.out.println(queue.poll());
        }

    }

    class StreamData implements Comparable<StreamData> {
        int pos;
        String value;

        StreamData(int pos, String value) {
            this.pos = pos;
            this.value = value;
        }

        public int compareTo(StreamData o) {
            return this.pos - o.pos;
        }

        @Override
        public String toString() {
            return "StreamData{" +
                    "pos=" + pos +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
