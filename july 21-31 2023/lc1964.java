// You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n, 
// where obstacles[i] describes the height of the ith obstacle.

// For every index i between 0 and n - 1 (inclusive), find the length of the longest obstacle course in 
// obstacles such that:

// You choose any number of obstacles between 0 and i inclusive.
// You must include the ith obstacle in the course.
// You must put the chosen obstacles in the same order as they appear in obstacles.
// Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.
// Return an array ans of length n, where ans[i] is the length of the longest obstacle course for index i as 
// described above.

import java.util.ArrayList;
import java.util.List;

public class lc1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles)
    {
       
        int n = obstacles.length;
        int[] dp = new int[n]; 
        List<Integer> lis = new ArrayList<>(); 

        for (int i = 0; i < n; i++) 
        {
            int obstacle = obstacles[i];
         
            if (lis.size()==0 || lis.get(lis.size()-1)<=obstacles[i]) 
            {
                lis.add(obstacle);
                dp[i]=lis.size();
            } 
            else 
            {
                   int idx = binarySearch(lis, obstacle); 
                lis.set(idx, obstacle);
                   dp[i] = idx + 1; 
            }
}

        // System.out.println(lis);

        return dp;
    }
    private int binarySearch(List<Integer> lis, int target) 
    {
        int left = 0;
        int right = lis.size() - 1;

        while (left <= right) 
        {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) <= target) 
            {
                left = mid + 1;
            } 
            else 
            {
                right = mid - 1;
            }
        }

        return left;
    }
}
