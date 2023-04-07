// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.


class Solution {

    public int helper(int i,int[] coins,int tar, Integer[][] dp){

        if(i==0){

            if(tar%coins[i]==0)
            return tar/coins[i];

            return (int)1e9;
        }

        if(dp[i][tar]!=null)
        return dp[i][tar];

        int nottake=helper(i-1,coins,tar,dp);
        int take=(int)1e9;
        if(coins[i]<=tar)
        take=1+helper(i,coins,tar-coins[i],dp);

        return dp[i][tar]= Math.min(take,nottake);
        
            }
    public int coinChange(int[] coins, int amount) {
        
        // Integer[][] dp=new Integer[coins.length][amount+1];
        int[] prev=new int[amount+1];
        int[] curr=new int[amount+1];
        // int ans=helper(coins.length-1,coins,amount,dp);

        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0)
            prev[t]=t/coins[0];
            else
          prev[t]=(int)1e9;
            
                    }

                    for(int i=1;i<coins.length;i++){

                        for(int t=0;t<=amount;t++){
                            int nottake=prev[t];
                            int take=(int)1e9;
                            if(coins[i]<=t)
                            take=1+curr[t-coins[i]];

                            curr[t]= Math.min(take,nottake);

                        }
                        prev=curr;
                    }

int ans=prev[amount];
        if(ans>=1e9)
        return -1;

        return ans;
    }
}
