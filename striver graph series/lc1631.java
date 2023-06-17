// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
// where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, 
// (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
// You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

import java.util.PriorityQueue;

public class lc1631 {
    
      class Tuple{
        int dist;
        int row;
        int col;

        Tuple(int dist,int row,int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {

        int n=heights.length;
        int m=heights[0].length;
        int[][] distance=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }

        int[] xDir={-1,0,1,0};
        int[] yDir={0,1,0,-1};

distance[0][0]=0;
        PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>((x,y)->x.dist-y.dist);

        pq.add(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            Tuple tp=pq.remove();
            int diff=tp.dist;
            int x=tp.row;
            int y=tp.col;

            if(x==n-1 && y==m-1)
            return diff;
           
           for(int i=0;i<4;i++){
               int newX=x+xDir[i];
               int newY=y+yDir[i];

               if(newX>=0 && newX<n && newY>=0 && newY<m){
              int newEffort=Math.max(Math.abs(heights[newX][newY]-heights[x][y]),diff);

              if(newEffort<distance[newX][newY]){
                  distance[newX][newY]=newEffort;
                  pq.add(new Tuple(newEffort,newX,newY));
              }
               }
           }

        }

return 0;
        
    }
}
