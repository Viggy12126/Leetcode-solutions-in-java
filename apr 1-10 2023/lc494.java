// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.


class Solution {

    public void helper(int[] nums, int target,int[] ans,int i){

        if(i==-1){
            if(target==0)
            ans[0]++;

            return;
        }

        helper(nums,target+nums[i],ans,i-1);//subtract
        helper(nums,target-nums[i],ans,i-1);//add

    }
    public int findTargetSumWays(int[] nums, int target) {

        int[] ans=new int[1];
        helper(nums,target,ans,nums.length-1);

        return ans[0];
        
    }
}
