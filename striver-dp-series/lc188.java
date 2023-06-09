// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

public class lc188 {
    
       public int maxProfit(int k, int[] arr) {
        
          int n=arr.length;
        int[][][] dp=new int[n+1][2][k+1];

    //    return f(0,1,2,n,prices,dp);

for(int i=n-1;i>=0;i--){
for(int buy=0;buy<=1;buy++){
    for(int cap=1;cap<=k;cap++){
        int profit=0;
         if(buy==1){
           profit=Math.max(-arr[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
        }else{
        profit=Math.max(arr[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
        }
dp[i][buy][cap]=profit;

    }
}
}

return dp[0][1][k];
    }
}
