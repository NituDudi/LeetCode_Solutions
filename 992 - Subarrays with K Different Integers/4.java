class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int K_count = KCount(nums, k);
        int K_1count = KCount(nums, k - 1);
        return K_count - K_1count;
    }

    public int KCount(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int left = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int right = 0; right < n; right++) {
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);

            while (hm.size() > k) {
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0) {
                    hm.remove(nums[left]);
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
