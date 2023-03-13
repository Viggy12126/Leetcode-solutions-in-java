//  https://bit.ly/3r8mG5b


// import java.util.* ;
// import java.io.*; 
public class dp18 {

	static int m=(int)(1e9+7);
	public static int f(int i,int sum,int[] arr,Integer[][] dp){
 
if(i==0){
if(sum==0 && arr[0]==0)
return 2;

if(sum==0 || sum==arr[0])
return 1;

return 0;
}

if(dp[i][sum]!=null)
return dp[i][sum];

int not_take=f(i-1,sum,arr,dp);
int take=0;
if(sum>=arr[i])
take=f(i-1,sum-arr[i],arr,dp);

return dp[i][sum]= (take+not_take)%m;
	}

	public static int findWays(int[] arr,int tar,int n){

		Integer[][] dp=new Integer[n][tar+1];

		return f(n-1,tar,arr,dp);
	}
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=arr[i];
		}

if(sum-d<0 || (sum-d)%2!=0)return 0;

		return findWays(arr,(sum-d)/2,n);
	}
}