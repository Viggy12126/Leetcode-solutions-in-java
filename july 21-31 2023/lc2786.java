// You are given a 0-indexed integer array nums and a positive integer x.

// You are initially at position 0 in the array and you can visit other positions according to the following rules:

// If you are currently in position i, then you can move to any position j such that i < j.
// For each position i that you visit, you get a score of nums[i].
// If you move from a position i to a position j and the parities of nums[i] and nums[j] differ, 
// then you lose a score of x.
// Return the maximum total score you can get.

// Note that initially you have nums[0] points.

class Solution {

    public long fun(int[] arr,int i,int f,Long[][] dp,int x){

    if(i>=arr.length)
    return 0;

    if(dp[i][f]!=null)
    return dp[i][f];

long take=0;
        if(arr[i]%2==f){
        take=arr[i]+fun(arr,i+1,f,dp,x);
        }else{
            take=arr[i]-x+fun(arr,i+1,arr[i]%2,dp,x);
        }

        long nottake=fun(arr,i+1,f,dp,x);

       return dp[i][f]=Math.max(take,nottake);
    }
    public long maxScore(int[] nums, int x) {
        
        int n=nums.length;
        Long[][] dp=new Long[n][2];

        // for(int i=0;i<2;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        int f=nums[0]%2==0?0:1;

        return fun(nums,1,f,dp,x)+nums[0];
        
        // dp[0]=nums[0];
        // long ans=0;
        
        // for(int i=1;i<n;i++){
            
        //     int num1=nums[i];
        //     // int f=0;
        //     // if(num%2!=0)
        //     //     f=1;
            
        //     long max=0;
            
        //     for(int j=0;j<i;j++){
                
        //         int num2=nums[j];
                 
        //         if((num1%2==0 && num2%2==0) || (num1%2!=0 && num2%2!=0)){
        //             max=Math.max(num1+dp[j],max);
        //         }else{
        //             max=Math.max(num1+dp[j]-x,max);
        //         }
                
        //     }
            
        //     dp[i]=max;
        //     ans=Math.max(ans,dp[i]);
        // }
        
        // return ans;
        
    }
}