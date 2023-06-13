import java.util.LinkedList;
import java.util.Queue;

public class lc1091 {
    class tuple{
        int first;
        int sec;
        int third;

        tuple(int first,int sec,int third){
            this.first=first;
            this.sec=sec;
            this.third=third;

        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {

        Queue<tuple> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;

        if(n==1 && m==1 && grid[0][0]==0)
        return 1;

        int[][] dist=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        if(grid[0][0]==0)
        dist[0][0]=0;

int[] xCord={0,1,1,1,0,-1,-1,-1};
int[] yCord={1,1,0,-1,-1,-1,0,1};

 if(grid[0][0]==0)
        q.add(new tuple(1,0,0));

        while(!q.isEmpty()){
            int dis=q.peek().first;
            int x=q.peek().sec;
            int y=q.peek().third;
            q.remove();
      
      for(int i=0;i<8;i++){
          int newX=x+xCord[i];
          int newY=y+yCord[i];

          if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY]==0 && dis+1<dist[newX][newY]){
              dist[newX][newY]=dis+1;

              if(newX==n-1 && newY==m-1)
              return dis+1;

              q.add(new tuple(dist[newX][newY],newX,newY));

          }
      }
}
        
        return -1;
    }
}
