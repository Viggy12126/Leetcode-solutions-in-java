// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).



class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        //  int[][] dp=new int[n][m];
        int[] prev=new int[m];
          int[] curr=new int[m];
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            prev[i]=matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){

                if(j==0){
                  curr[j]=Math.min(matrix[i][j]+prev[j],matrix[i][j]+prev[j+1]);
                }else if(j==m-1){
                    curr[j]=Math.min(matrix[i][j]+prev[j],matrix[i][j]+prev[j-1]);

                }else{
    curr[j]=Math.min(matrix[i][j]+prev[j],Math.min(matrix[i][j]+prev[j-1],matrix[i][j]+prev[j+1]));
                }
                  System.out.println(curr[j]);
            }

          
            prev=curr;
        }

for(int i=0;i<m;i++){
    // System.out.println(prev[i]);
            ans=Math.min(ans,prev[i]);
        }

        return ans;


    }
}
