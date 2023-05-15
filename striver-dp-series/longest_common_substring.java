public class longest_common_substring {
    
    public static int lcs(String str1, String str2) {
		// Write your code here.

		int n=str1.length();
    int m=str2.length();
  int[][] dp=new int[n+1][m+1];

    // return helper(text1,text2,n,m,dp);

    for(int i=0;i<=n;i++)
    dp[i][0]=0;

    for(int j=0;j<=m;j++)
    dp[0][j]=0;
	
int max=0;
	 for(int i=1;i<=n;i++){
		 for(int j=1;j<=m;j++){
			 if(str1.charAt(i-1)==str2.charAt(j-1)){
				 dp[i][j]=1+dp[i-1][j-1];
				 max=Math.max(max,dp[i][j]);
			 }else 
			 dp[i][j]=0;
		 }
	 }

	return max;
}
}
