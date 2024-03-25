// You are given a positive integer k. Initially, you have an array nums = [1].

// You can perform any of the following operations on the array any number of times (possibly zero):

// Choose any element in the array and increase its value by 1.
// Duplicate any element in the array and add it to the end of the array.
// Return the minimum number of operations required to make the sum of elements of the final array greater than or equal to k.

class Solution {

    public boolean isPossible(int num,int k){

        int sum=0;
        for(int i=1;i<=num;i++){
       
       sum=(i+1)*(num-i+1);

       if(sum>=k)
       return true;
        }

        return false;
    }
    public int minOperations(int k) {

        if(k==1)
        return 0;

        int ans=0;
        int low=0;
        int high=k;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(mid,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}