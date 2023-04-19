// We define the conversion array conver of an array arr as follows:

// conver[i] = arr[i] + max(arr[0..i]) where max(arr[0..i]) is the maximum value of arr[j] over 0 <= j <= i.
// We also define the score of an array arr as the sum of the values of the conversion array of arr.

// Given a 0-indexed integer array nums of length n, return an array ans of length n where ans[i] is the score of the prefix nums[0..i]


class Solution {
    public long[] findPrefixScore(int[] nums) {
        
        int n=nums.length;
        long[] ans=new long[n];
          // long[] conver=new long[n];
        int max=0;
        long sum=0;
        
        for(int i=0;i<n;i++){
            
            
            max=Math.max(max,nums[i]);
            sum+=nums[i]+max;  
            // sum+=conver[i];
            ans[i]=sum;
        
        }
        
        return ans;
    }
}
