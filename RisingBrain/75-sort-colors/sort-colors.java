class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        //two pointer approach
        //iterate mid if found (1 swap the low ,low++,mid++ and 2 swap with high, high--)
        //left side will be sorted
        int low =0, mid =0, high = n-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int value = nums[high];
                nums[high]=nums[mid];
                nums[mid]=value;
                high--;
            }
        }



        //bubble sort
        // for(int i =0;i<n;i++){
        //     for(int j=0;j<n-i-1;j++){   // because last elements are sorted.
        //         if(nums[j]>nums[j+1]){
        //             int temp = nums[j];
        //             nums[j]=nums[j+1];
        //             nums[j+1]=temp;
        //         }
        //     }
        // }
    }
}