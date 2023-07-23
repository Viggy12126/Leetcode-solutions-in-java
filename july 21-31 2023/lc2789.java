// You are given a 0-indexed array nums consisting of positive integers.

// You can do the following operation on the array any number of times:

// Choose an integer i such that 0 <= i < nums.length - 1 and nums[i] <= nums[i + 1]. Replace the element 
// nums[i + 1] with nums[i] + nums[i + 1] and delete the element nums[i] from the array.
// Return the value of the largest element that you can possibly obtain in the final array.

public class lc2789 {
    public long maxArrayValue(int[] nums) {
        
        long ans=0;
        int n=nums.length;
        
        if(n==1)
            return nums[0];
        
        long[] pre=new long[n];
        long[] suf=new long[n];
        
        pre[0]=nums[0];
        
        for(int i=1;i<n-1;i++){
            
            if(nums[i]>=pre[i-1])
                pre[i]=pre[i-1]+nums[i];
            else
                pre[i]=nums[i];
        }
        
        if(pre[n-2]<=nums[n-1])
            pre[n-1]=pre[n-2]+nums[n-1];
        else
            pre[n-1]=nums[n-1];
        
        suf[n-1]=nums[n-1];
        
        for(int i=n-2;i>=1;i--){
            
            if(nums[i]<=suf[i+1])
                suf[i]=suf[i+1]+nums[i];
            else
                suf[i]=nums[i];
        }
        
        if(suf[1]>=nums[0])
            suf[0]=nums[0]+suf[1];
        else
            suf[0]=nums[0];
        
        for(int i=0;i<n;i++)
            ans=Math.max(ans,Math.max(pre[i],suf[i]));
        
        return ans;
        
    }
}
