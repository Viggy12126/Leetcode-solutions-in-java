import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class largest_divisible_subset {
     public List<Integer> largestDivisibleSubset(int[] arr) {
        
        	int n=arr.length;
		int[] dp=new int[n];
		int[] hash=new int[n];

	Arrays.fill(dp,1);
    Arrays.sort(arr);

	 int ans=1;
	 int li=0;

	 for(int i=1;i<n;i++){
	
hash[i]=i;
		 for(int prev=0;prev<i;prev++){
			 if(arr[i]%arr[prev]==0 && 1+dp[prev]>dp[i]){
			dp[i]=1+dp[prev];
			hash[i]=prev;
			 }
		 }
		

		  if(dp[i]>ans){
            ans=dp[i];
             li=i;
		  }
	 }

int[] lis=new int[ans];
lis[0]=arr[li];
int ind=1;


List<Integer> list=new ArrayList<>();
// list.add(arr[li]);

while(hash[li]!=li){
	li=hash[li];

	if(ind<lis.length)
	lis[ind]=arr[li];

	ind++;
	// list.add(arr[li]);
}

for(int i=lis.length-1;i>=0;i--){
	list.add(lis[i]);
}
return list;
    }
}
