import java.util.* ;
import java.io.*; 

public class 01knap{

    public static int helper(int[] weight, int[] value, int i, int maxWeight,Integer[][] dp){


if(i==0){
    if(weight[0]<=maxWeight)
    return value[0];

    return 0;
}

if(dp[i][maxWeight]!=null)
return dp[i][maxWeight];

int notTake=helper(weight,value,i-1,maxWeight,dp);

int take=Integer.MIN_VALUE;
if(weight[i]<=maxWeight)
take=value[i]+helper(weight, value, i-1, maxWeight-weight[i], dp);

return dp[i][maxWeight]=Math.max(take,notTake);
    
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

         

            int[][] dp=new int[n][maxWeight+1];

            // return helper(weight,value,n-1,maxWeight,dp);

            for(int w=weight[0];w<=maxWeight;w++)
            dp[0][w]=value[0];

            for(int i=1;i<n;i++){
                for(int w=0;w<=maxWeight;w++){
                    int nottake=dp[i-1][w];
                    int take=Integer.MIN_VALUE;
                    if(w>=weight[i])
                    take=value[i]+dp[i-1][w-weight[i]];

                    dp[i][w]=Math.max(nottake,take);
                }
            }

            return dp[n-1][maxWeight];

    }
} 
