public class longest_mountain_in_array {
    
    public int longestMountain(int[] arr) {
 
       int[] dp1 = new int[arr.length];
	    int[] dp2 = new int[arr.length];
	    dp1[0] = 1;
	    
	    for(int i = 1; i < dp1.length; i++) {
	    	if(arr[i-1] < arr[i])
	    		dp1[i] = dp1[i-1] + 1;
	    	else
	    		dp1[i] = 1;
	    }
	    
	    dp2[dp2.length - 1] = 1;
	    for(int i = dp2.length - 2; i >= 0; i--) {
	    	if(arr[i] > arr[i+1])
	    		dp2[i] = dp2[i+1] + 1;
	    	else
	    		dp2[i] = 1;
	    }
	    
	    int ans = 0;
	    for(int i = 0; i < dp1.length; i++) {
            if(dp1[i] > 1 && dp2[i] > 1)
	    	    ans = Math.max(ans, dp1[i] + dp2[i] - 1);

                // System.out.println(dp1[i]+" "+dp2[i]);
	    }
	    
	    if(ans < 3)
	    	return 0;
		return ans;
    }
}
