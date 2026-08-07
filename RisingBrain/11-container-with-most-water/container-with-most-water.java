class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        //max_area = height * width
        //compare left and right, if left is smaller increment it 
        //if right is smaller decreament it.
        int left =0, right =n-1;
        int max_area =0;

        while(left < right){
            int area = (right-left)*(Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            max_area= Math.max(max_area,area);
        }
        return max_area;



        // iterate every element find lowest between two pole(i,j) then multiply with width(j-i);
        // int max_area = 0;
        // for(int i =0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         int h = Math.min(height[i], height[j]);
        //         int w = j-i;
        //         int area = h*w;
        //         max_area = Math.max(area,max_area);
        //     }
        // }
        // return max_area;
        
    }
}