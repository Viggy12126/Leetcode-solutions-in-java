// You have n computers. You are given the integer n and a 0-indexed integer array batteries where the 
// ith battery can run a computer for batteries[i] minutes. You are interested in running all n computers 
// simultaneously using the given batteries.

// Initially, you can insert at most one battery into each computer. After that and at any integer time moment, 
// you can remove a battery from a computer and insert another battery any number of times. The inserted battery 
// can be a totally new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.

// Note that the batteries cannot be recharged.

// Return the maximum number of minutes you can run all the n computers simultaneously.

public class lc2141 {
    public long maxRunTime(int n, int[] batteries) {
        long low = 1;
        long high = 0;
        
        for (int battery : batteries) {
            high += battery;
        }
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canRunAllComputers(n, batteries, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high; // high represents the last successful time (maximum time)
    }
    
    private boolean canRunAllComputers(int n, int[] batteries, long time) {
        long computersRunning = 0;
        
        for (int battery : batteries) {
            computersRunning += Math.min(battery, time);
        }
        
        return computersRunning >= time * n;
    }
}
