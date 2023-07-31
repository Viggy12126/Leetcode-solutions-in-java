//Burst ballons

public class lc312 {
    public int fun(int left,int right,int[] arr,Integer[][] dp){

        if(left>right)
        return 0;

        if(dp[left][right]!=null)
        return dp[left][right];

        int ans=Integer.MIN_VALUE;

        for(int i=left;i<=right;i++){

            int cost=arr[i]*arr[left-1]*arr[right+1];
            int left_cost=fun(left,i-1,arr,dp);
            int right_cost=fun(i+1,right,arr,dp);

            ans=Math.max(ans,cost+left_cost+right_cost);

        }

        return dp[left][right]=ans;


    }
    public int maxCoins(int[] nums) {
       
       int n=nums.length;
        int[] arr=new int[n+2];

          arr[0] = 1; arr[n+1] = 1;
        for(int i = 1; i <= n; i++) arr[i] = nums[i-1];

        Integer[][] dp=new Integer[n+2][n+2];

        return fun(1,n,arr,dp); 
        
    }
}
