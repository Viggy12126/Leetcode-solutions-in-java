// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

import java.util.*;
class Solution {

    public boolean isSafe(String[][] board,int row,int col,int n){

        int dupRow=row;
        int dupCol=col;

        //upper left diagonal
        while(row>=0 && col>=0){

            if(board[row][col]=="Q")
            return false;

            row--;
            col--;
        }

        //back straight
        row=dupRow;
        col=dupCol;
        while(col>=0){
            if(board[row][col]=="Q")
            return false;

            col--;

        }

        //lower left diagonal
        row=dupRow;
        col=dupCol;
        while(row<n && col>=0){
            if(board[row][col]=="Q")
            return false;

            row++;
            col--;

        }

        return true;

    }

    public void solve (String[][] board, List<List<String>> ans,int n,int col){

        if(col==n){
            List<String> list=new ArrayList<>();
        
         for(int i=0;i<n;i++){
             String temp="";
             for(int j=0;j<n;j++){
                 temp+=board[i][j];
             }
             list.add(temp);
         }
         

         ans.add(new ArrayList<>(list));
         return;
        
        }

        for(int row=0;row<n;row++){
       
       if(isSafe(board,row,col,n)){
           board[row][col]="Q";
           solve(board,ans,n,col+1);
           board[row][col]=".";
       }


        }

    }
    public List<List<String>> solveNQueens(int n) {

        String[][] board=new String[n][n];
         List<List<String>> ans=new ArrayList<>();
         List<String> list=new ArrayList<>();

         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 board[i][j]=".";
             }
         }

         solve(board,ans,n,0);

         return ans;


        
    }
}
