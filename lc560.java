// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        
     HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int ans=0;
        int sum=0;

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){

        //         if(i==j){
        //         // arr.add(nums[i]);
        //         sum=nums[i];
        //         if(sum==k)
        //         ans++;
        //         }
        //         else{
        //         // arr.add(nums[i]+nums[j]);
        //         if(sum+nums[j]==k)
        //         ans++;

        //         sum=sum+nums[j];
        //         }
        //     }
        // }

        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];

            if(map.containsKey(sum-k))
            ans+=map.get(sum-k);


          map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}
