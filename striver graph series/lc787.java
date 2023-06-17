// There are n cities connected by some number of flights. You are given an array flights where 
// flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at 
// most k stops. If there is no such route, return -1

import java.util.*;
public class lc787 {
    
    class Pair{
        int first;
        int sec;

        Pair(int first,int sec){
            this.first=first;
            this.sec=sec;
        }
    }

    class Tuple{
        int first;
        int sec;
        int third;
        

        Tuple(int first,int sec,int third){
           
            this.first=first;
            this.sec=sec;
            this.third=third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
         int first=flights[i][0];
         int sec=flights[i][1];
         int third=flights[i][2];

         adj.get(first).add(new Pair(sec,third));
        }

        int[] dist=new int[n];

        for(int i=0;i<n;i++)
        dist[i]=Integer.MAX_VALUE;

        dist[src]=0;

        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
       
        while(!q.isEmpty()){
            Tuple tp=q.remove();
           
           int stops=tp.first;
           int node=tp.sec;
           int cost=tp.third;

           if(stops > k) continue; 
      
      for(Pair p:adj.get(node)){
               int adjNode=p.first;
               int newCost=p.sec;

               if(cost+newCost<dist[adjNode] && stops<=k){
                   dist[adjNode]=cost+newCost;
                   q.add(new Tuple(stops+1,adjNode,dist[adjNode]));
               }
           }
        }

        if(dist[dst]!=Integer.MAX_VALUE)
        return dist[dst];

        return -1;
    }
}
