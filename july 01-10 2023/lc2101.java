// You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. 
//This area is in the shape of a circle with the center as the location of the bomb.

// The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri].
// xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, 
//whereas ri denotes the radius of its range.

// You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie 
//in its range. These bombs will further detonate the bombs that lie in their ranges.

// Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed 
//to detonate only one bomb.

import java.util.ArrayList;
import java.util.List;

public class lc2101 {
    
    private void dfs(List<List<Integer>> gr, boolean[] visited, int[] c, int i) {
visited[i] = true;
c[0]++;
for (int j : gr.get(i)) {
if (!visited[j]) {
dfs(gr, visited, c, j);
}
}
}
public int maximumDetonation(int[][] bombs) {
int n = bombs.length;
List<List<Integer>> gr = new ArrayList<>(n);
for (int i = 0; i < n; i++) {
gr.add(new ArrayList<>());
for (int j = 0; j < n; j++) {
if (i != j) {
long x1 = bombs[i][0];
long y1 = bombs[i][1];
long r1 = bombs[i][2];
long x = bombs[j][0];
long y = bombs[j][1];
long distanceSq = (x - x1) * (x - x1) + (y - y1) * (y - y1);
if (distanceSq <= r1 * r1) {
gr.get(i).add(j);
}
}
}
}
int ans = Integer.MIN_VALUE;

for (int i = 0; i < n; i++) {
int[] c = new int[1];
boolean[] visited = new boolean[n];
dfs(gr, visited, c, i);
ans = Math.max(ans, c[0]);
}
return ans;
}
}

// class Solution {


//     public void bfs(Queue<Integer> q,int[][] bombs,int[] ct,boolean[] vis){

//         while(q.size()>0){

//   int i=q.remove();
            
//             if(!vis[i])
//             ct[0]++;
            
//             vis[i]=true;

//             for(int j=0;j<bombs.length;j++){

//                 if(j!=i){
                 
//                  long x1=bombs[i][0];
//                  long y1=bombs[i][1];
//                  long r=bombs[i][2];

//                  long x2=bombs[j][0];
//                  long y2=bombs[j][1];

//                  if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<=r*r && vis[j]==false){
//                      q.add(j);
//                  }

//                 }
//             }
//         }
//     }
//     public int maximumDetonation(int[][] bombs) {
        
//         int n=bombs.length;
//         int ans=1;

//         Queue<Integer> q=new LinkedList<>();

//         for(int i=0;i<n;i++){

//             q.add(i);
//             int[] ct=new int[1];
//             boolean[] vis=new boolean[n];
//             bfs(q,bombs,ct,vis);
//             ans=Math.max(ans,ct[0]);
//         }

//         return ans;


//     }
// }