class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            total_sum = total_sum + nums[i];
        }
        int left_sum = 0;
        int right_sum = total_sum;
        for (int i = 0; i < nums.length; i++) {
            right_sum -= nums[i];
            if (left_sum == right_sum) {
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }
}