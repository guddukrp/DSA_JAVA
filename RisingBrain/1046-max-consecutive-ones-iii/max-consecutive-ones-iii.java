class Solution {
    public int longestOnes(int[] nums, int k) {

        //increment right until found window with k zeros 
        //on k+1 zero decremtn the countZero and more left
        //then right-left +1 because we are breaking before last element. 
        int maxOnes = 0, left = 0, countZero = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                countZero++;
            }
            while (countZero > k) {
                if (nums[left] == 0) {
                    countZero--;
                }
                left++;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;

        // for every left count Ones with O(n2)
        // int maxOnes =0;
        // for(int l =0;l<nums.length;l++){
        //     int countZero=0;
        //     for(int r =l;r <nums.length; r++){
        //         if(nums[r]==0){
        //             countZero++;
        //         }
        //         if(countZero>k){
        //             break;
        //         }
        //         maxOnes = Math.max(maxOnes,r-l+1);
        //     }
        // }
        // return maxOnes;
    }
}