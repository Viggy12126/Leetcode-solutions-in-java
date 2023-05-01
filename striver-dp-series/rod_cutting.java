public class rod_cutting {
    public static int helper(int[] arr,int i,int n,
Integer[][] dp){

		if(i==0){

			return (n*arr[0]);
		}

if(dp[i][n]!=null)
return dp[i][n];

int nottake=helper(arr,i-1,n,dp);
int take=Integer.MIN_VALUE;
if(i+1<=n)
take=arr[i]+helper(arr, i, n-(i+1),dp);

return Math.max(take, nottake);

	}
	public static int cutRod(int price[], int n) {
		// Write your code here.

int[][] dp=new int[n][n+1];
		// return helper(price,n-1,n,dp);

for(int i=0;i<=n;i++)
dp[0][i]=i*price[0];

for(int i=1;i<n;i++){

	for(int j=0;j<=n;j++){

		int nottake=dp[i-1][j];
		int take=Integer.MIN_VALUE;
		if(i+1<=j)
		take=price[i]+dp[i][j-(i+1)];

		dp[i][j]=Math.max(take, nottake);

	}
}

return dp[n-1][n];
	}
}
