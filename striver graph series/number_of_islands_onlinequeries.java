import java.util.ArrayList;
import java.util.List;

public class number_of_islands_onlinequeries {
    
     private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
    
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

    
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        //Your code here
        
        DisjointSet ds=new DisjointSet(n*m);
        int[][] vis=new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        
        int[] xDir={-1,1,0,0};
        int[] yDir={0,0,1,-1};
        
        for(int i=0;i<len;i++){
            
            int row=operators[i][0];
            int col=operators[i][1];
            
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            
            vis[row][col]=1;
            cnt++;
            
            for(int ind=0;ind<4;ind++){
                
                int x=row+xDir[ind];
                int y=col+yDir[ind];
                
                if(isValid(x,y,n,m) && vis[x][y]==1){
                    
                    int nodeNo = row * m + col;
                    int adjNodeNo = x * m + y;
                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            cnt--;
                            ds.unionByRank(nodeNo, adjNodeNo);
                        }
                    
                }
            }
            
            ans.add(cnt);
        }
        
        return ans;
        
        
    }
}
