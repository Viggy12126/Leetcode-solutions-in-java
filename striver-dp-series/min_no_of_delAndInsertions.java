//Problem link:- https://bit.ly/3pya8CP

public class min_no_of_delAndInsertions {
    
    public static int canYouMake(String s1, String s2) {
        // Write your code here.

        int n=s1.length();
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

   int lcs= dp[n][m];

   return n+m-2*lcs;
    }
}
