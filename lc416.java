// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
class Solution {

    public static boolean helper(int[] arr,int i,Boolean[][] dp,int sum){
  
  if(i==arr.length){
      if(sum==0)
      return true;

      return false;
  }
 
if(sum<0 || i>=arr.length){
          return false;
      }

  if(sum==0)
  return true;

  if(dp[i][sum]!=null)
  return dp[i][sum];

  boolean op1=helper(arr,i+1,dp,sum-arr[i]);
   boolean op2=helper(arr,i+1,dp,sum);

  return dp[i][sum]=(op1 || op2);

      
  }
  public boolean canPartition(int[] nums) {
      
      int k=0;
      int n=nums.length;


    

      for(int i=0;i<n;i++){
          k+=nums[i];
      }

        if(k%2!=0)
      return false;

      k=k/2;
      boolean[][] dp=new boolean[n+1][k+1];

//   return helper(nums,0,dp,k);

for(int i=0;i<n;i++){
  dp[i][n-1]=true;
}
dp[n-1][nums[0]]=true;

for(int i=n-2;i>=1;i--){
  for(int tar=k;tar>=1;tar--){

      boolean notTake=dp[i+1][tar];
      boolean take=false;

      if(tar-nums[i]>=0)
       take=dp[i+1][tar-nums[i]];

      dp[i][tar]=(notTake || take);
  }
}

return dp[0][k];




  }
}