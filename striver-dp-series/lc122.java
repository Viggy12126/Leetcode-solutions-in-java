// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at 
// any time. However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.

class Solution {

    public int f(int i,int buy,int[] arr,int n,Integer[][] dp){

        if(i==n)
        return 0;

        if(dp[i][buy]!=null)
        return dp[i][buy];

int profit=0;
        if(buy==1){
 profit=Math.max(-arr[i]+f(i+1,0,arr,n,dp),f(i+1,1,arr,n,dp));
        }else{
            profit=Math.max(arr[i]+f(i+1,1,arr,n,dp),f(i+1,0,arr,n,dp));

        }

        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] arr) {
        
        int n=arr.length;
        int[][] dp=new int[n+1][2];

dp[n][0]=dp[n][1]=0;

for(int i=n-1;i>=0;i--){
    for(int buy=0;buy<=1;buy++){
        
int profit=0;

if(buy==1){
profit=Math.max(-arr[i]+dp[i+1][0],dp[i+1][1]);
}else{
 profit=Math.max(arr[i]+dp[i+1][1],dp[i+1][0]);
}

dp[i][buy]=profit;
    }
}
        // return f(0,1,arr,n,dp);

        return dp[0][1];
    }
}