class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // Expand the window with right until sum >= target, then shrink from left.
        // Track the minimum valid window length.

        int left = 0;
        int ans = Integer.MAX_VALUE, sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(right - left + 1, ans);
                sum = sum - nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }
}