import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max_days = 0;

        for (int i = 0; i < events.length; i++) {
            max_days = Math.max(max_days, events[i][1]);
        }

        int count = 0;
        int day = 1;
        int i = 0;

        while (day <= max_days) {
            while (i < events.length && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }

            day++;
        }

        return count;
    }
}
