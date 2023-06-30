public class unboundedknap {
    public static int helper(int n, int w, int[] profit, int[] weight,int i,Integer[][] dp){

        if(i==0){

            return ((int)(w/weight[0])*profit[0]);
        }

if(dp[i][w]!=null)
return dp[i][w];

        int nottake=helper(n,w,profit,weight,i-1,dp);
        int take=0;
        if(weight[i]<=w)
        take=profit[i] + helper(n,w-weight[i],profit,weight,i,dp);

        return dp[i][w]= Math.max(take,nottake);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
int[][] dp=new int[n][w+1];
        // return helper(n,w,profit,weight,n-1,dp);
   
   for(int i=weight[0];i<=w;i++)
   dp[0][i]=((int)(i/weight[0])*profit[0]);

   for(int i=1;i<n;i++){

       for(int j=0;j<=w;j++){
           int nottake=dp[i-1][j];

           int take=0;
           if(weight[i]<=j)
           take=profit[i]+dp[i][j-weight[i]];

           dp[i][j]=Math.max(take,nottake);
       }
   }
        
        return dp[n-1][w];
    }
}
