class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        //for every iteration add right and remove left element
        //Maintain a set of unique element if found duplicate skip else add element in set.
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        long sum = 0, maxSum = 0;

        for (int right = 0; right < nums.length; right++) {

            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
        }

        return maxSum;

        //Here maintain the frequecy of element if that is 0 remove from map else increment on right element and decrement on left element found.
        //if map size = k then only calculate maxSum

        // long sum = 0, maxSum = 0;
        // Map<Integer, Integer> map = new HashMap<>();

        // int left = 0;
        // for (int right = 0; right < nums.length; right++) {
        //     sum += nums[right];
        //     map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

        //     if (right - left + 1 > k) {
        //         map.put(nums[left], map.get(nums[left]) - 1);
        //         if (map.get(nums[left]) == 0) {
        //             map.remove(nums[left]);
        //         }
        //         sum -= nums[left];
        //         left++;
        //     }

        //     if (right - left + 1 == k && map.size() == k) {
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }
        // return maxSum;

    }
}