// You are given an array of integers nums and an integer target.

// Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7

import java.util.*;
class Solution {

    public void helper(int[] nums,int tar,int i, int[] ans, ArrayList<Integer> arr){

    //    if(arr.size()>=1){
    //       System.out.println(arr);
    //       if(arr.get(0)+arr.get(arr.size()-1)<=tar)
    //       ans[0]++;
      
    //    }
        
        if(i==nums.length){
  if(arr.size()>=1){
          System.out.println(arr);
          if(arr.get(0)+arr.get(arr.size()-1)<=tar)
          ans[0]++;
      
       }

return;
        }
        

        if(arr.size()>0 && (arr.get(0)+arr.get(arr.size()-1)>tar))
        return;

        // int not_pick=helper(nums,curr_sum,tar,i+1);
        // int pick=0;
        // if(nums[i]<=tar)
        // pick=helper(nums,curr_sum+nums[i],tar,i+1);

        // return pick+not_pick;
helper(nums,tar,i+1,ans,arr);

if(nums[i]<=tar){
    arr.add(nums[i]);
helper(nums,tar,i+1,ans,arr);
arr.remove(arr.size()-1);
}


    }
    public int numSubseq(int[] nums, int target) {
        
        int n=nums.length;
       int m=(int)1e9 + 7;
       int ans=0;

//         // Integer[][] dp=new Integer[n][target+1];
//         ArrayList<Integer> arr=new ArrayList<>();
  int[] pow=new int[n];
  pow[0]=1;
  Arrays.sort(nums);
//        helper(nums,target,0,ans,arr);

//        return ans[0];

for(int i=1;i<n;i++){
    pow[i]=(pow[i-1]*2)%m;
}

int i=0;
int j=n-1;

while(i<=j){

    if(nums[i]+nums[j]<=target){
 ans=(ans+pow[j-i])%m;
 i++;
    }else
    j--;
}

return ans;

    }
}