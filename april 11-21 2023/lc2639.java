// You are given a 0-indexed m x n integer matrix grid. The width of a column is the maximum length of its integers.

// For example, if grid = [[-10], [3], [12]], the width of the only column is 3 since -10 is of length 3.
// Return an integer array ans of size n where ans[i] is the width of the ith column.

// The length of an integer x with len digits is equal to len if x is non-negative, and len + 1 otherwise.

class Solution {
    
    public int length(int digit){
        
        String s=Integer.toString(digit);
        
        int len=0;
      
        
        int n=s.length();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
          
                len++;
        }
        
        return len;
    }
    public int[] findColumnWidth(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int[] ans=new int[m];
        
        for(int col=0;col<m;col++){
            
            int max_len=0;
          
            for(int row=0;row<n;row++){
                
                int val=grid[row][col];
                
              max_len=Math.max(max_len,length(val));
                    System.out.println(length(val)+" "+val+" "+max_len);  
                
      
             ans[col]=max_len;
        }
        
        return ans;
    }
}
}
