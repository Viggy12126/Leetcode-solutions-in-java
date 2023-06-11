public class lis {
    
    public int f(int i,int prev,int[] arr,int n,Integer[][] dp){

        if(i==n)
        return 0;

        if(dp[i][prev+1]!=null)
        return dp[i][prev+1];

        int nottake=f(i+1,prev,arr,n,dp);
        int take=0;
        if(prev==-1 || arr[i]>arr[prev])
        take=1+f(i+1,i,arr,n,dp);

        return dp[i][prev+1]=Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] arr) {
        
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];

        // return f(0,-1,nums,n,dp);

        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
             int nottake=dp[i+1][prev+1];
             int take=0;
              if(prev==-1 || arr[i]>arr[prev])
        take=1+dp[i+1][i+1];

        dp[i][prev+1]=Math.max(take,nottake);

            }

            
        }

        return dp[0][0];
    }
}
