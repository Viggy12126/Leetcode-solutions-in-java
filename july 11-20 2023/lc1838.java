// The frequency of an element is the number of times it occurs in an array.

// You are given an integer array nums and an integer k. In one operation, you can choose an index of nums 
// and increment the element at that index by 1.

// Return the maximum possible frequency of an element after performing at most k operations.

import java.util.Arrays;

public class lc1838 {
    
      public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n=nums.length;

        int i=0;
        int j=0;
        int sum=0;
        int ans=0;

        while(j<n){

            sum+=nums[j];
            while((j-i+1)*nums[j]-sum>k){
               sum-=nums[i];
               i++;
            }

            ans=Math.max(ans,j-i+1);
            j++;
            // System.out.println(ans+" "+i+" "+j);
        }

return ans;
    }
}
