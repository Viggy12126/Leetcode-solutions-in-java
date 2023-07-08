import java.util.Arrays;

public class min_cost_to_cut_stick {
    public int f(int i,int j,int[] arr,Integer[][] dp){

        if(i>j)
        return 0;
        
 if(dp[i][j]!=null)
        return dp[i][j];

int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
   int cost=arr[j+1]-arr[i-1]+f(i,k-1,arr,dp)+f(k+1,j,arr,dp);
   min=Math.min(min,cost);
        }

        return dp[i][j]=min;

    }

//     public int f(int left,int right,int[] cuts,Integer[][] dp){

//         if(right-left<0)
//         return 0;

//         if(dp[left][right]!=null)
//         return dp[left][right];

// int ans=Integer.MAX_VALUE;
//         for(int i=0;i<cuts.length;i++){

// if(cuts[i]>left && cuts[i]<right){
// ans=Math.min(ans,right-left+f(left,cuts[i],cuts,dp)+f(cuts[i],right,cuts,dp));
// }
//  }

//         if(ans==Integer.MAX_VALUE)
//         return dp[left][right]= 0;

//         return dp[left][right]= ans;


//     }
    public int minCost(int n, int[] cuts) {

int len=cuts.length;

   Arrays.sort(cuts);
        
        int[] arr = new int[len+2];
        for(int i = 1 ; i <= len ; i++)
            arr[i] = cuts[i-1];
        
        arr[0] = 0;
        arr[len+1] = n;

Integer[][] dp=new Integer[len+1][len+1];
        return f(1,len,arr,dp);
    }
}
