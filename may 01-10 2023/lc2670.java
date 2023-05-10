// You are given a 0-indexed array nums of length n.

// The distinct difference array of nums is an array diff of length n such that diff[i] is equal to the number of distinct elements in the suffix nums[i + 1, ..., n - 1] subtracted from the number of distinct elements in the prefix nums[0, ..., i].

// Return the distinct difference array of nums.

// Note that nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j inclusive. Particularly, if i > j then nums[i, ..., j] denotes an empty subarray.


import java.util.*;
public class lc2670 {
    
    public int[] distinctDifferenceArray(int[] nums) {
        
        int n=nums.length;
        int[] vis1=new int[51];
        int[] vis2=new int[51];
        
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        int c1=0;
        int c2=0;
        
        
        for(int i=0;i<n;i++){
            
            if(vis1[nums[i]]==0){
                c1++;
                map1.put(i,c1);
                vis1[nums[i]]=1;
            }else{
                  map1.put(i,c1);
            }
        }
        
        
         for(int i=n-1;i>=0;i--){
            
             
            if(vis2[nums[i]]==0){
                c2++;
                map2.put(i,c2);
                vis2[nums[i]]=1;
            }else{
                  map2.put(i,c2);
            }
        }
        
        // System.out.println(map1);
        //  System.out.println(map2);
        
        int[] ans=new int[n];
        
        for(int i=0;i<n-1;i++){
            
           ans[i]=map1.get(i)-map2.get(i+1);
        }
        
        ans[n-1]=map1.get(n-1);
        
        return ans;
        
        
        
        
        
    }
}
