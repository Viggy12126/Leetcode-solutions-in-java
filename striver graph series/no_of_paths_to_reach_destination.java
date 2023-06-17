import java.util.ArrayList;
import java.util.PriorityQueue;

public class no_of_paths_to_reach_destination {
    
    class Pair {
    int first;
    int second;
    
     Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
    public int countPaths(int n, int[][] roads) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.second-y.second);

         ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }
        int m = roads.length;
          int mod = 1000000007;

          for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

         int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e18;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair rem=pq.remove();

            int node=rem.first;
            int dis=rem.second;

            for(Pair it:adj.get(node)){
                int adjNode=it.first;
                int d=it.second;

                if(dis+d<dist[adjNode]){
                dist[adjNode]=dis+d;
                 ways[adjNode]=ways[node];
                 pq.add(new Pair(adjNode,dis+d));
                }
                else if(dis+d==dist[adjNode]){
                    ways[adjNode]=(ways[adjNode]+ways[node])%mod;
                }

            }
        }

        return ways[n-1];
    }
}
