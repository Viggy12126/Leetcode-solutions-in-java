
// You are given a 0-indexed integer array nums.

// Initially, all of the indices are unmarked. You are allowed to make this operation any number of times:

// Pick two different unmarked indices i and j such that 2 * nums[i] <= nums[j], then mark i and j.
// Return the maximum possible number of marked indices in nums using the above operation any number of times.


import java.util.*;
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int j=n/2;
        int ans=0;
        
        while(i<n/2 && j<n){
            
            if(2*nums[i]<=nums[j]){
                j++;
                i++;
                ans+=2;
            }else{
                j++;
            }
        }
        
        return ans;
        
    }
}
