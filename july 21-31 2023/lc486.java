// You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

// Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. 
// At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or 
// nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their 
// score. The game ends when there are no more elements in the array.

// Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the 
// winner, and you should also return true. You may assume that both players are playing optimally.

public class lc486 {
    public int fun(int l,int r,int[] arr, Integer[][] dp){

        if(l>r)
        return 0;

if(dp[l][r]!=null)
return dp[l][r];

        int op1=arr[l]-fun(l+1,r,arr,dp);
        int op2=arr[r]-fun(l,r-1,arr,dp);

        return dp[l][r]= Math.max(op1,op2);
    }
    public boolean PredictTheWinner(int[] nums) {
        
        int n=nums.length;
        Integer[][] dp=new Integer[n+1][n+1];
       int ans= fun(0,n-1,nums,dp);

       if(ans>=0)
       return true;

       return false;
    }
}
