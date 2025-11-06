class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int left = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            left = Math.max(left, weights[i]);
        }
        int right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (helper(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // mid → ship capacity being tested
    public boolean helper(int[] weights, int mid, int days) {
        int days_needed = 1;  // start from day 1
        int wt = 0;

        for (int i = 0; i < weights.length; i++) {
            if (wt + weights[i] > mid) {
                days_needed++;
                wt = 0;
            }
            wt += weights[i];
        }

        return days_needed <= days;
    }
}
