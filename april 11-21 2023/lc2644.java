// You are given two 0-indexed integer arrays nums and divisors.

// The divisibility score of divisors[i] is the number of indices j such that nums[j] is divisible by divisors[i].

// Return the integer divisors[i] with the maximum divisibility score. If there is more than one integer with the maximum score, return the minimum of them.


import java.util.*;
public class lc2644 {
    
    public int maxDivScore(int[] nums, int[] divisors) {
        
        int n=nums.length;
        int m=divisors.length;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<m;i++){

int count=0;
            for(int j=0;j<n;j++){

                int num1=divisors[i];
                int num2=nums[j];

                if(num2%num1==0){
                    count++;
                }
            }

            map.put(divisors[i],count);
        }

int ans=1000000001;

int max_count=0;

        for(int i=0;i<m;i++){
        int val=map.get(divisors[i]);

        if(val>max_count){
            max_count=val;
            ans=divisors[i];
        }else if(val==max_count){
        ans=Math.min(ans,divisors[i]);
        }
        }
        
        return ans;
    }
}
