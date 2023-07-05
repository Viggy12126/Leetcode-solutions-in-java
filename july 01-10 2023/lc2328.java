// You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 
// directions.

// Return the number of strictly increasing paths in the grid such that you can start from any cell and end at 
// any cell. Since the answer may be very large, return it modulo 109 + 7.

// Two paths are considered different if they do not have exactly the same sequence of visited cells.

public class lc2328 {
    
    int mod=(int)(1e9+7);

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
            ans=(ans%mod+dfs(nx,ny,grid,dp)%mod)%mod;
        }
    }

    return dp[x][y]=ans%mod;
}
    public int countPaths(int[][] grid) {
        
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

       long count=0;

       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               count=(count%mod+dfs(i,j,grid,dp)%mod)%mod;
            //    System.out.println(count);
           }
       }

       return (int)count%mod;

    // long ans=0;

    // for(int i=m-1;i>=0;i--){
    //     for(int j=n-1;j>=0;j--){

    //         if(i==m-1){
          
    //       if(j==n-1)
    //       dp[i][j]=1;

    //       else{
    //           if(grid[i][j]<grid[i][j+1])
    //           dp[i][j]=(dp[i][j]%mod+dp[i][j+1]%mod)%mod;
    //       }

        
    //         }else if(j==n-1){

    //             if(i==m-1)
    //             dp[i][j]=1;

    //             else{
            
    //         if(grid[i][j]<grid[i+1][j])
    //         dp[i][j]=(dp[i][j]%mod+dp[i+1][j]%mod)%mod;
    //             }
    //         }else{

    //         if(grid[i][j]<grid[i+1][j])
    //         dp[i][j]=(dp[i][j]%mod+dp[i+1][j]%mod)%mod;

    //         if(grid[i][j]<grid[i][j+1])
    //            dp[i][j]=(dp[i][j]%mod+dp[i][j+1]%mod)%mod;
    //         }

    //           ans=(ans%mod+dp[i][j]%mod)%mod;
    //     }
    // }

    // return (int)ans%mod;
    }
}
