// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

public class lc53 {
    
    public int maxSubArray(int[] nums) {
        
        int curr_sum=nums[0];
        int max_sum=nums[0];
        int n=nums.length;

        for(int i=1;i<n;i++){

            if(curr_sum>=0)
            curr_sum+=nums[i];
            else
            curr_sum=nums[i];

            if(max_sum<curr_sum)
            max_sum=curr_sum;
        }

        return max_sum;
    }
}
