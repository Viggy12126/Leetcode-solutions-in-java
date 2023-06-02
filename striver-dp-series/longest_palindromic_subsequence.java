class Solution {
    public int longestPalindromeSubseq(String s) {
        
        String s1=s;
        String s2="";

        int n=s1.length();
        for(int i=n-1;i>=0;i--){
            s2+=s1.charAt(i);
        }

         int m=s2.length();
      int[][] dp=new int[n+1][m+1];

        // return helper(text1,text2,n,m,dp);

        for(int i=0;i<=n;i++)
        dp[i][0]=0;

        for(int j=0;j<=m;j++)
        dp[0][j]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
 if(s1.charAt(i-1)==s2.charAt(j-1))
 dp[i][j]=1+dp[i-1][j-1];
 else
 dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        return dp[n][m];
    }
}