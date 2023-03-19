class Solution {
    
    int[] xDir={1,1,2,2,-1,-1,-2,-2};
    int[] yDir={-2,2,-1,1,-2,2,-1,1};
    
    public boolean isSafe(int x,int y,int n){
        
        if(x>=0 && x<n && y>=0 && y<n)
            return true;
        
        return false;
    }
    
    public boolean helper(int[][] grid,int n,int move,int x,int y){
        
        if(move==n*n-1)
            return true;
        
        
        for(int i=0;i<8;i++){
            int moveX=x+xDir[i];
            int moveY=y+yDir[i];
            
            if(isSafe(moveX,moveY,n) && grid[moveX][moveY]==move+1){
                
                boolean ans=helper(grid,n,move+1,moveX,moveY);
                if(ans)
                    return true;
            }
                
        }
        
        return false;
        
        
    }
    public boolean checkValidGrid(int[][] grid) {
        
        int n=grid.length;
        
        return helper(grid,n,0,0,0);
    }
}
