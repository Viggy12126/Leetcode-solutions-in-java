// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

// A land cell if grid[r][c] = 0, or
// A water cell containing grid[r][c] fish, if grid[r][c] > 0.
// A fisher can start at any water cell (r, c) and can do the following operations any number of times:

// Catch all the fish at cell (r, c), or
// Move to any adjacent water cell.
// Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

public class lc2658 {
    
    int[] x={0,0,1,-1};
    int[] y={1,-1,0,0};
    
    public boolean isSafe(int X,int Y,int[][] grid){
        
        int n=grid.length;
        int m=grid[0].length;
        
        if(X>=0 && X<n && Y>=0 && Y<m)
            return true;
        
        return false;
    }
    public void dfs(int[][] grid,int row,int col,boolean[][] vis,int[] count){
        
        vis[row][col]=true;
        count[0]+=grid[row][col];
        System.out.println(count[0]);
        for(int i=0;i<4;i++){
            int xDir=row+x[i];
            int yDir=col+y[i];
            
            if(isSafe(xDir,yDir,grid) && vis[xDir][yDir]==false && grid[xDir][yDir]>0){
                dfs(grid,xDir,yDir,vis,count);
            }
        }
        
        // vis[row][col]=false;
        
    }
 
    public int findMaxFish(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean[][] vis=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                
                if(grid[i][j]>0 && vis[i][j]==false){
                    int[] count=new int[1];
                    dfs(grid,i,j,vis,count);
                    ans=Math.max(ans,count[0]);
                }
            }
        }
        
        return ans;
    }
}
