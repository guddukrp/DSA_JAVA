class Solution {
    public int trap(int[] height) {
        int n = height.length;
        //In leftMax and rightMax move and update smaller one
        //then add contains the water

        int left = 0, right = n - 1, water = 0;
        int leftMax = height[left], rightMax = height[right];

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;

        //2.we can store leftMax and rightMax in two array then find totalWater

        //3.find leftMax and rightMax of every element 
        //then totalWater += Min(leftMax,rightMax)-element

        // int totalWater = 0;
        // for (int i = 0; i < n; i++) {
        //     int leftMax = 0, rightMax = 0;
        //     for (int j = 0; j <= i; j++) {
        //         leftMax = Math.max(leftMax, height[j]);
        //     }
        //     for (int k = i; k < n; k++) {
        //         rightMax = Math.max(rightMax, height[k]);
        //     }
        //     totalWater += (Math.min(leftMax, rightMax) - height[i]);
        // }
        // return totalWater;

    }
}
