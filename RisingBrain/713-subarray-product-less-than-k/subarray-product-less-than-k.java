class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        // Expand right; shrink left when product >= k.
        // Number of valid subarrays ending at right = right - left + 1.
        int count = 0;
        int prod = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            prod = prod * nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;

        // Start from each index and multiply until product >= k.
        // Since all elements are positive, break when product >= k.
        // int count = 0;
        // if (k <= 1) {
        //     return 0;
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     int prod = 1;
        //     for (int j = i; j < nums.length; j++) {
        //         prod = prod * nums[j];
        //         if (prod < k) {
        //             count++;
        //         } else {
        //             break;
        //         }
        //     }
        // }
        // return count;
    }
}