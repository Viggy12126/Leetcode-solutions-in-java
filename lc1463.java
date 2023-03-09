// You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

// You have two robots that can collect cherries for you:

// Robot #1 is located at the top-left corner (0, 0), and
// Robot #2 is located at the top-right corner (0, cols - 1).
// Return the maximum number of cherries collection using both robots by following the rules below:

// From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
// When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
// When both robots stay in the same cell, only one takes the cherries.
// Both robots cannot move outside of the grid at any moment.
// Both robots should reach the bottom row in grid.


class Solution {

    public int helper(int i,int j1,int j2,int m,int[][] grid,Integer[][][] dp){
        
        if(j1<0 || j2<0 || j1>=m || j2>=m)
        return -1;
  
        if(i==grid.length-1){
            if(j1==j2)
            return grid[i][j1];
            else
            return grid[i][j1]+grid[i][j2];
        }
  
        if(dp[i][j1][j2]!=null)
        return dp[i][j1][j2];
  
  int max=Integer.MIN_VALUE;
        for(int k1=-1;k1<=1;k1++){
  
            for(int k2=-1;k2<=1;k2++){
  
                if(j1==j2)
                max=Math.max(max,grid[i][j1]+helper(i+1,j1+k1,j2+k2,m,grid,dp));
                else
              max=Math.max(max,grid[i][j1]+grid[i][j2]+helper(i+1,j1+k1,j2+k2,m,grid,dp));
            }
        }
  
        return dp[i][j1][j2]= max;
  
  
      }
      public int cherryPickup(int[][] grid) {
  
           Integer[][][] dp=new Integer[grid.length][grid[0].length][grid[0].length];
  
          return helper(0,0,grid[0].length-1,grid[0].length,grid,dp);
          
      }
  }