// You are installing a billboard and want it to have the largest height. The billboard will have two steel 
//supports, one on each side. Each steel support must be an equal height.

// You are given a collection of rods that can be welded together. For example, if you have rods of lengths 
//1, 2, and 3, you can weld them together to make a support of length 6.

// Return the largest possible height of your billboard installation. If you cannot support the billboard, 
//return 0.

class Solution {

    public int f(int[] arr,int i,int diff, Integer[][] dp){

        if(i==arr.length){

            if(diff==0)
            return 0;

            return Integer.MIN_VALUE;
        }

      if(dp[i][diff+5000]!=null)
        return dp[i][diff+5000];

        int nottake=f(arr,i+1,diff,dp);
        int take=Math.max(arr[i]+f(arr,i+1,diff+arr[i],dp),f(arr,i+1,diff-arr[i],dp));

        return dp[i][diff+5000]= Math.max(take,nottake);

    }
    public int tallestBillboard(int[] rods) {
        
        Integer[][] dp=new Integer[rods.length+1][10001];;
        // return f(rods,0,0,0);
       return f(rods,0,0,dp);
    }
}