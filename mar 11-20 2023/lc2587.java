// You are given a 0-indexed integer array nums. You can rearrange the elements of nums to any order (including the given order).

// Let prefix be the array containing the prefix sums of nums after rearranging it. In other words, prefix[i] is the sum of the elements from 0 to i in nums after rearranging it. The score of nums is the number of positive integers in the array prefix.

// Return the maximum score you can achieve.

import java.util.*;
class Solution {
    public int maxScore(int[] arr) {
        
        Integer[] nums=new Integer[arr.length];
        
        for(int i=0;i<arr.length;i++){
            nums[i]=arr[i];
        }
           Arrays.sort(nums, Collections.reverseOrder());
        int n=nums.length;
        
        long[] pre=new long[n];
        pre[0]=nums[0];
     
        int ans=0;
        
           if(pre[0]>0)
            ans++;
        
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
            // System.out.println(pre[i]);
            if(pre[i]>0)
                ans++;
        }
        
        return ans;
        
        
    }
}