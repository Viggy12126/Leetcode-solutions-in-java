// Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:

// answer.length == nums.length.
// answer[i] = |leftSum[i] - rightSum[i]|.
// Where:

// leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
// rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
// Return the array answer.

class Solution {
    public int[] leftRigthDifference(int[] nums) {
        
        int n=nums.length;
        int ans[]=new int[n];
        
        int[] ls=new int[n];
        int[] rs=new int[n];
        
        ls[0]=0;
        rs[n-1]=0;
        
        for(int i=1;i<n;i++){
            
           ls[i]=ls[i-1]+nums[i-1];
            
                
        }
        
        for(int i=n-2;i>=0;i--){
            rs[i]=rs[i+1]+nums[i+1];
        }
        
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(rs[i]-ls[i]);
        }
        
        return ans;
        
    }
}