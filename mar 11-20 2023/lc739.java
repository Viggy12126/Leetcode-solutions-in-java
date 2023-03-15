// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();

        ans[n-1]=0;
        st.push(n-1);

        for(int i=n-2;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()]<=arr[i])
            st.pop();

            if(st.isEmpty())
            ans[i]=0;
            else{
                ans[i]=Math.abs(i-st.peek());
            }

            st.push(i);
        }

        return ans;
    }
}
