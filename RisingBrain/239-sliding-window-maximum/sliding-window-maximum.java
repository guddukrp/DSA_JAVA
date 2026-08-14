class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int ans[] = new int[nums.length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            // Remove indices that are outside the current window.
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            // Remove smaller elements; they can never become the maximum.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            // Keep indices in decreasing order of their values.
            deque.addLast(right);

            // Front of deque always contains the maximum of the current window.
            if (right >= k - 1) {
                ans[right - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;

        //move window of size k and find max for every window

        // int[] ans = new int[nums.length - k + 1];
        // for (int i = 0; i <= nums.length - k; i++) {
        //     int max = Integer.MIN_VALUE;
        //     for (int j = i; j < i + k; j++) {
        //         max = Math.max(max, nums[j]);
        //     }
        //     ans[i] = max;
        // }
        // return ans;
    }
}