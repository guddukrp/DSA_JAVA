class Solution {
    public int maxSubarraySum(int[] arr, int k) {
      
        //find sum of first window of size k then slide one index at a time.
        
        int sum=0, maxSum = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+= arr[i];
        }
        
        for(int j=0;j<arr.length-k;j++){
            sum = sum +arr[j+k]-arr[j];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
        
        // int maxSum = Integer.MIN_VALUE;
        // for(int i =0;i<=arr.length-k;i++){
        //     int sum=0;
        //     for(int j=i;j<i+k;j++){
        //         sum+=arr[j];
        //     }
        //     maxSum = Math.max(maxSum,sum);
        // }
        // return maxSum;
    }
}
