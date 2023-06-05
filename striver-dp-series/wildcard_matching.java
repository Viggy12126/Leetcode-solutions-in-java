public class wildcard_matching {
    
    public boolean f(int i,int j,String s,String p,Boolean[][] dp){

        if(i<0 && j<0)
        return true;

        if(i<0 && j>=0)
        return false;

        if(j<0 && i>=0){
            for(int ii=0;ii<=i;ii++){
                if(s.charAt(ii)!='*')
                return false;
            }
            return true;
        }

        if(dp[i][j]!=null)
        return dp[i][j];

        if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?')
        return dp[i][j]=f(i-1,j-1,s,p,dp);

        if(s.charAt(i)=='*')
        return dp[i][j]=f(i-1,j,s,p,dp) || f(i,j-1,s,p,dp);

        return false;


    }
    public boolean isMatch(String s, String p) {

        int n=p.length();
        int m=s.length();

        boolean[][] dp=new boolean[n+1][m+1];
        // return f(n-1,m-1,p,s,dp);
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=false;
            }
        }
dp[0][0]=true;

for(int j=1;j<=m;j++)
dp[0][j]=false;

for(int i=1;i<=n;i++){
    boolean flag=true;
 for(int ii=1;ii<=i;ii++){
                if(p.charAt(ii-1)!='*'){
                flag=false;
                break;
                }
            }

            dp[i][0]=flag;

}

for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
        if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='?')
        dp[i][j]=dp[i-1][j-1];

        else if(p.charAt(i-1)=='*'){
            dp[i][j]=dp[i-1][j] || dp[i][j-1];
        }
        else
        dp[i][j]=false;
    }
}

return dp[n][m];

        
    }
}
