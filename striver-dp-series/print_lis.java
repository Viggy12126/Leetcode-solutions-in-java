import java.util.ArrayList;
import java.util.Arrays;

public class print_lis {
    
    public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
	int n=arr.length;
		int[] dp=new int[n];
		int[] hash=new int[n];

	Arrays.fill(dp,1);
	 int ans=1;
	 int li=0;

	 for(int i=1;i<n;i++){
		 hash[i]=i;
		 for(int prev=0;prev<i;prev++){
			 if(arr[i]>arr[prev] && 1+dp[prev]>dp[i])
			dp[i]=1+dp[prev];
			hash[i]=prev;
		 }
		

		  if(dp[i]>ans){
            ans=dp[i];
             li=i;
		  }
	 }

// int[] lis=new int[ans];
// lis[0]=arr[li];
//int ind=1;


ArrayList<Integer> list=new ArrayList<>();
list.add(arr[li]);

while(hash[li]!=li){
	li=hash[li];
	// lis[ind++]=arr[li];
	list.add(arr[li]);
}

// System.out.println(Collections.reverse(list));

	 return ans;
	}
}
