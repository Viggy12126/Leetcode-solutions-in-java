// Given an m x n integers matrix, return the length of the longest increasing path in matrix.

// From each cell, you can either move in four directions: left, right, up, or down. You may not move 
// diagonally or move outside the boundary (i.e., wrap-around is not allowed).

public class lc329 {
    int dx[]={1,0,-1,0};
    int dy[]={0,1,0,-1};

   public boolean isValid(int x,int y,int[][] grid){

        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length)
        return true;

        return false;
    }
    public int dfs(int x,int y,int[][] grid,int[][] dp){

    if(dp[x][y]!=-1)
    return dp[x][y];

    int ans=1;

    for(int i=0;i<4;i++){

        int nx=x+dx[i];
        int ny=y+dy[i];

        if(isValid(nx,ny,grid) && grid[nx][ny]>grid[x][y]){
            ans=Math.max(ans,(1+dfs(nx,ny,grid,dp)));
        }
    }

    return dp[x][y]=ans;
}
    public int longestIncreasingPath(int[][] grid) {
        

        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        int ans=1;

       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               ans=Math.max(ans,dfs(i,j,grid,dp));
            //    System.out.println(ans);
           }
       }

       return ans;
    }
}
