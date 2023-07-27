// You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at 
// startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also 
// given an integer k which represents the maximum number of events you can attend.

// You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. 
// Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the 
// other ends on the same day.

// Return the maximum sum of values that you can receive by attending events.

import java.util.*;

public class lc1751 {
    class Triplet {
        int i;
        int k;
        int prevEndDay;
        public Triplet(int i, int k, int prevEndDay){
            this.i = i;
            this.k = k;
            this.prevEndDay = prevEndDay;
        }
    }

    public int f(int i,int prev,int[][] arr,int k, Map<Triplet, Integer> dp){

        if(i>=arr.length || k==0)
        return 0;

        if(dp.containsKey(new Triplet(i,k,prev)))
        return dp.get(new Triplet(i,k,prev));

        int nottake=f(i+1,prev,arr,k,dp);
        int take=0;
        if(prev<arr[i][0])
        take=arr[i][2]+f(i+1,arr[i][1],arr,k-1,dp);

        // System.out.println(take+" "+nottake);

        int ans=Math.max(take,nottake);
        Triplet tp=new Triplet(i,k,prev);

dp.put(tp,ans);

        return dp.get(tp);
    }

    public int getValidIndex(int events[][], int n, int idx, int val) {
        int low = idx;
        int high = n - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > val) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public int fun(int[][] arr,int n,int ind,int k,Integer[][] dp){

        if(ind>=n || k==0 || ind==-1)
        return 0;

        if(dp[ind][k]!=null)
        return dp[ind][k];

        int i=getValidIndex(arr,n,ind,arr[ind][1]);
       
        // for(i=ind+1;i<n;i++){

        //     if(arr[ind][1]<arr[i][0])
        //   break;
        // }
        
          int take=arr[ind][2]+fun(arr,n,i,k-1,dp);

        int nottake=fun(arr,n,ind+1,k,dp);

        return dp[ind][k]= Math.max(take,nottake);
    }
    public int maxValue(int[][] events, int k) {
        
             Arrays.sort(
            events,
            (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        );
        //  int prev=0;

       
        //  Map<Triplet, Integer> dp= new HashMap<>();
       
        // return f(0,prev,events,k,dp);

        Integer[][] dp=new Integer[events.length+1][k+1];

        return fun(events,events.length,0,k,dp);
    }
}
