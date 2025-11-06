class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
        }

        if (n == k) {
            return total;
        }

        int left = 0;
        int right = 0;
        int min_score = Integer.MAX_VALUE;
        int score = 0;

        while (right < n) {
            score += cardPoints[right];

            if (right - left + 1 == n - k) {
                min_score = Math.min(min_score, score);
                score -= cardPoints[left];
                left++;
            }

            right++;
        }

        return total - min_score;
    }
}
