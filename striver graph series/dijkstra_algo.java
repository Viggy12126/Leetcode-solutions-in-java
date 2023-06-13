import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair{
    int distance;
    int node;
    Pair(int distance,int node){
        this.distance=distance;
        this.node=node;
    }
    
}

public class dijkstra_algo {
    
 static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        int[] ans=new int[V];
        
        for(int i=0;i<V;i++)
        ans[i]=Integer.MAX_VALUE;
        
        ans[S]=0;
        pq.add(new Pair(0,S));
        
        while(!pq.isEmpty()){
            int dist=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            
            for(int i=0;i<adj.get(node).size();i++){
                int wt=adj.get(node).get(i).get(1);
                int adjNode=adj.get(node).get(i).get(0);
                
                if(dist+wt<ans[adjNode]){
                ans[adjNode]=dist+wt;
                pq.add(new Pair(ans[adjNode],adjNode));
                }
            }
        }
        
        return ans;
    }
}
