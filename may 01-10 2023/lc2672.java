// There is a 0-indexed array nums of length n. Initially, all elements are uncolored (has a value of 0).

// You are given a 2D integer array queries where queries[i] = [indexi, colori].

// For each query, you color the index indexi with the color colori in the array nums.

// Return an array answer of the same length as queries where answer[i] is the number of adjacent elements with the same color after the ith query.

// More formally, answer[i] is the number of indices j, such that 0 <= j < n - 1 and nums[j] == nums[j + 1] and nums[j] != 0 after the ith query

public class lc2672 {
    
    public int[] colorTheArray(int n, int[][] queries) {
        
        int[] ans=new int[queries.length];
          int[] color=new int[n];
        int count=0;
        
        for(int i=0;i<queries.length;i++){
            
            int ind=queries[i][0];
            int col=queries[i][1];
            
            int left=ind-1<0 ? 0 : color[ind-1];
            int right=ind+1==n ? 0 : color[ind+1];
            
            if(color[ind]!=0 && color[ind]==left)
                count--;
            
            if(color[ind]!=0 && color[ind]==right)
                count--;
            
            color[ind]=col;
            
               if(color[ind]==left)
                count++;
        
            
            if( color[ind]==right)
                count++;
             
            
            ans[i]=count;
            
        }
        
        return ans;
        
    }
}
