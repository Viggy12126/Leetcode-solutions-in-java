import java.util.LinkedList;
import java.util.Queue;

public class min_multiplications_to_reach_end {
    
    class Pair{
        int node;
        int dist;
        
        Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,0));
       
         int mod = 100000;
         int n=arr.length;
         boolean[] vis=new boolean[mod+1];
        
        while(!q.isEmpty()){
            Pair rem=q.remove();
            int no=rem.node;
            int dis=rem.dist;
            
           if(no==end)
            return dis;
            
           for(int i=0;i<n;i++){
                int val=(no*arr[i])%mod;
                 if(!vis[val]){
            vis[val]=true;
                q.add(new Pair(val,dis+1));
                 }
            
                
            }
            
        }
        
        
        return -1;
        
        
        
    }
}
