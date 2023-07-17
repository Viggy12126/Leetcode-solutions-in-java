// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are 
// horizontally or vertically neighboring. The same letter cell may not be used more than once.

public class lc79 {
    int[] xCord={0,1,0,-1};
    int[] yCord={1,0,-1,0};

    public boolean dfs(int x,int y,char[][] board,String word,boolean[][] vis,int n,int ind){
 

     if(ind>=n)
     return true;

if(x<0 || x>=board.length || y<0 || y>=board[0].length || vis[x][y]==true || board[x][y]!=word.charAt(ind))
     return false;

     vis[x][y]=true;

     for(int i=0;i<4;i++){

         int xDir=x+xCord[i];
         int yDir=y+yCord[i];

       boolean found=dfs(xDir,yDir,board,word,vis,n,ind+1);

       if(found)
       return true;
     }

  vis[x][y]=false;
     return false;

    }
    public boolean exist(char[][] board, String word) {
        
        int n=word.length();
        boolean[][] vis=new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[0].length;j++){

                if(board[i][j]==word.charAt(0)){

                    boolean ans=dfs(i,j,board,word,vis,n,0);

                    if(ans)
                    return true;
                }
            }
        }

      

        return false;
    }
}
