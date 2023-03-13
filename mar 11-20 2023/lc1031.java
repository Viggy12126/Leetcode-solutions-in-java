// Given an integer array nums and two integers firstLen and secondLen, return the maximum sum of elements in two non-overlapping subarrays with lengths firstLen and secondLen.

// The array with length firstLen could occur before or after the array with length secondLen, but they have to be non-overlapping.

// A subarray is a contiguous part of an array.

class Solution {

    public int solution(int[] nums,int n, int x, int y){
    
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        int sum=0;
    
        for(int i=0;i<n;i++){
    
            if(i<x){
             sum+=nums[i];
             dp1[i]=sum;
            }else{
                sum+=nums[i]-nums[i-x];
                dp1[i]=Math.max(dp1[i-1],sum);
    
            }
        }
        sum=0;
    
        for(int i=n-1;i>=0;i--){
            if(i+y>=n){
       sum+=nums[i];
             dp2[i]=sum;
            }else{
                sum+=nums[i]-nums[i+y];
        dp2[i]=Math.max(dp2[i+1],sum);
            }
        }
        int ans=0;
    
        for(int i=x-1;i<n-y;i++){
    ans=Math.max(ans,dp1[i]+dp2[i+1]);
        }
    
        return ans;
    }
        public int maxSumTwoNoOverlap(int[] nums, int x, int y) {
            
            int n=nums.length;
            int first=solution(nums,n,x,y);
            int sec=solution(nums,n,y,x);
    
            return Math.max(first,sec);
        }
    }
