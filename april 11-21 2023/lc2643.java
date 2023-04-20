// Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the number of ones in that row.

// In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.

// Return an array containing the index of the row, and the number of ones in it.

public class lc2643 {
    
    public int[] rowAndMaximumOnes(int[][] mat) {
        
        int m=mat.length;
        int n=mat[0].length;
        int max_count=0;
        int min_index=m;
        
        for(int i=0;i<m;i++){
            
            int count=0;
            for(int j=0;j<n;j++){
                
                int val=mat[i][j];
                
                if(val==1){
                    count++;
                    // max_count=Math.max(max_count,count);
                    // min_index=Math.min(min_index,i);
                    
                  
                }
            }
            
              if(count>max_count){
                        max_count=count;
                       min_index=i;
                    }else if(count==max_count){
                           min_index=Math.min(min_index,i);         

              }
        }
        int[] ans=new int[2];
        
        if(max_count==0)
            ans[0]=0;
        else
        ans[0]=min_index;
        
        ans[1]=max_count;
        
        return ans;
    }
}
