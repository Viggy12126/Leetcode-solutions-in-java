
// There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

// At the first minute, color any arbitrary unit cell blue.
// Every minute thereafter, color blue every uncolored cell that touches a blue cell.
// Below is a pictorial representation of the state of the grid after minutes 1, 2, and 3.




class Solution {
    public long coloredCells(int n) {
        
        long ans=0;
        long[] arr=new long[n+1];
        arr[1]=1;
        
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+4*(i-1);
            // System.out.println(arr[i]);
            ans+=arr[i];
}
        
        return arr[n];
        
        
    }
}