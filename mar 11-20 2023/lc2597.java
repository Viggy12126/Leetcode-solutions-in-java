// You are given an array nums of positive integers and a positive integer k.

// A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.

// Return the number of non-empty beautiful subsets of the array nums.

// A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.



import java.util.*;
class Solution {
    
    public void helper(int[] nums, int k, ArrayList<ArrayList<Integer>> arr, int ans[],  ArrayList<Integer> set,int i){
        
        if(i==nums.length){
            
            if(set.size()>0){
                arr.add(new ArrayList<>(set));
            }
            
            
             return;
        }
           
        
//    
        
      
        
        //pick
        if(!(set.contains(nums[i]-k))){
            
            set.add(nums[i]);
        
        helper(nums,k,arr,ans,set,i+1);
        set.remove(set.size()-1);
        }
        
        
        //not pick
         helper(nums,k,arr,ans,set,i+1);
    }
    public int beautifulSubsets(int[] nums, int k) {
        
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
  ArrayList<Integer> set=new ArrayList<>();
        int ans[]=new int[1];
        Arrays.sort(nums);
        
        helper(nums,k,arr,ans,set,0);
        
        return arr.size();
        
    }
}
        
        
      