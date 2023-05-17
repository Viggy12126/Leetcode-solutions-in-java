// You are given a 0-indexed 2D integer array nums. Initially, your score is 0. Perform the following operations until the matrix becomes empty:

// From each row in the matrix, select the largest number and remove it. In the case of a tie, it does not matter which number is chosen.
// Identify the highest number amongst all those removed in step 1. Add that number to your score.
// Return the final score

import java.util.*;
public class lc2679 {
    
    public int matrixSum(int[][] nums) {
        
        int row=nums.length;
        int col=nums[0].length;
        int ans=0;
        
         for(int i=0;i<nums.length;i++){
            Arrays.sort(nums[i]);
        }
        
        for(int i=0;i<col;i++){
            int max=0;

            for(int j=0;j<row;j++){
                // System.out.print(nums[j][i]+" ");
                max=Math.max(max,nums[j][i]);
            }
            // System.out.println();
            ans+=max;
        }
        
        return ans;
        
    }
}
