// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete at most two transactions.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

public class lc123 {
    
     public int f(int i,int buy,int cap,int n,int[] arr,Integer[][][] dp){

        if(i==n|| cap==0)
        return 0;

if(dp[i][buy][cap]!=null)
return dp[i][buy][cap];

int profit=0;
        if(buy==1){
           profit=Math.max(-arr[i]+f(i+1,0,cap,n,arr,dp),f(i+1,1,cap,n,arr,dp));
        }else{
        profit=Math.max(arr[i]+f(i+1,1,cap-1,n,arr,dp),f(i+1,0,cap,n,arr,dp));
        }

        return dp[i][buy][cap]=profit;
    }
    public int maxProfit(int[] arr) {
        
        int n=arr.length;
        int[][][] dp=new int[n+1][2][3];

    //    return f(0,1,2,n,prices,dp);

for(int i=n-1;i>=0;i--){
for(int buy=0;buy<=1;buy++){
    for(int cap=1;cap<=2;cap++){
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

return dp[0][1][2];

    }
}
