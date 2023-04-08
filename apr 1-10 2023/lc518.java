// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

class Solution {

    public int helper(int[] arr,int i,int tar, Integer[][] dp){

        if(i==0){
         if(tar%arr[0]==0)
         return 1;

         return 0;

        }

if(dp[i][tar]!=null)
return dp[i][tar];

        int nottake=helper(arr,i-1,tar,dp);
        int take=0;
        if(arr[i]<=tar)
        take=helper(arr,i,tar-arr[i],dp);

        return dp[i][tar]= take+nottake;
    }
    public int change(int amount, int[] coins) {
        
        int[][] dp=new int[coins.length][amount+1];
        // return helper(coins,coins.length-1,amount,dp);

        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0)
            dp[0][t]=1;
        }
 
 for(int i=1;i<coins.length;i++){
     for(int t=0;t<=amount;t++){
         int nottake=dp[i-1][t];
         int take=0;
         if(coins[i]<=t)
          take=dp[i][t-coins[i]];

          dp[i][t]=take+nottake;
     }
 }

 return dp[coins.length-1][amount];

        
    }
}
