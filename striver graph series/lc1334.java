import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

// Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

// Notice that the distance of a path connecting cities i and j is equal to 
// the sum of the edges' weights along that path.

public class lc1334 {
    class PairG43 {
	int dist;
	int node;

	public PairG43(int node, int dist) {
		this.node = node;
		this.dist = dist;

	}
}

 public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		
	
		int[][] costMatrix = new int[n][n];
		
		List<List<PairG43>> adjList=new ArrayList<List<PairG43>>();
		for(int i=0;i< n;i++) {
			adjList.add(new ArrayList<PairG43>());
		}
		
		for(int i=0;i< edges.length;i++) {
			adjList.get(edges[i][0]).add(new PairG43(edges[i][1], edges[i][2]));
			adjList.get(edges[i][1]).add(new PairG43(edges[i][0], edges[i][2]));	
		}

		for (int i = 0; i < n; i++) {
			int[] distanceNode=new int[n];
			Arrays.fill(distanceNode, (int)(1e9));
			PriorityQueue<PairG43> pq = new PriorityQueue<PairG43>((a, b) -> a.dist - b.dist);
			pq.add(new PairG43( i,0));
			distanceNode[i] = 0;
			
			while(!pq.isEmpty()) {
				int distance=pq.peek().dist;
				int node=pq.peek().node;
				pq.poll();
				
				for(PairG43 vertex:adjList.get(node)) {
					int v=vertex.node;
					int edW=vertex.dist;
					if (distanceNode[v] > distance + edW) {
						distanceNode[v] = distance + edW;
						pq.offer(new PairG43(v, distance + edW));

					}
				}
				
			}
			costMatrix[i] = distanceNode;
		}


		int count = n;
		int maxCity = -1;

		for (int city = 0; city < n; city++) {
			int cnt = 0;
			for (int adCity = 0; adCity < n; adCity++) {
				if (costMatrix[city][adCity] <= distanceThreshold) {
					cnt++;
				}
			}
			if (cnt <= count) {
				maxCity = city;
				count = cnt;
			}
		}

		return maxCity;
    }
}
