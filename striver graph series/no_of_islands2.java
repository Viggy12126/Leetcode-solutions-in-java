// You are given a n,m which means the row and column of the 2D matrix and an array of  size k 
// denoting the number of operations. Matrix elements is 0 if there is water or 1 if there is land. 
// Originally, the 2D matrix is all 0 which means there is no land in the matrix. 
// The array has k operator(s) and each operator has two integer A[i][0], A[i][1] means that you can change the 
// cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many island are there in the matrix after each 
// operation.You need to return an array of size k.
// Note : An island means group of 1s such that they share a common side.

import java.util.*;

class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0); 
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {

        if(node == parent.get(node)) {
            return node; 
        }

        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    public void unionByRank(int u, int v) {

        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        
        if(ulp_u == ulp_v) return; 

        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            int rankU = rank.get(ulp_u); 
            rank.set(ulp_u, rankU + 1); 
        }
    }
}

public class no_of_islands2 {

private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
    
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        //Your code here
        
         DisjointSet ds = new DisjointSet(n*m);
         List<Integer> ans=new ArrayList<>();
         int len=operators.length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        
         for (int i = 0; i < len ; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            // row - 1, col
            // row , col + 1
            // row + 1, col
            // row, col - 1;
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                if (isValid(adjr, adjc, n, m)) {
                    if (vis[adjr][adjc] == 1) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjr * m + adjc;
                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            cnt--;
                            ds.unionByRank(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
         
         
    }
    
}




