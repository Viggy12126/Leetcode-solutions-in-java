// Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, 
// and all the 0's and all the 1's in these substrings are grouped consecutively.

// Substrings that occur multiple times are counted the number of times they occur.

public class lc696 {
    public int countBinarySubstrings(String s) {
        
        int n=s.length();

        int[] suf0=new int[n];
        int[] suf1=new int[n];

        if(s.charAt(n-1)=='1')
        suf1[n-1]=1;
        else
        suf0[n-1]=1;

        for(int i=n-2;i>=0;i--){

            char ch=s.charAt(i);

            if(ch=='1'){
           suf1[i]=1+suf1[i+1];
           
            }else{
suf1[i]=0;
            }
        }

            for(int i=n-2;i>=0;i--){

            char ch=s.charAt(i);

            if(ch=='0'){
           suf0[i]=1+suf0[i+1];
           
            }else{
suf0[i]=0;
            }
        }
    
    int ans=0;

        for(int i=0;i<n;i++){
       
       char ch=s.charAt(i);

       if(ch=='0'){
      
      int count0=suf0[i];
      
      if(i+count0<n && suf1[i+count0]>=count0)
      ans++;

       }else{
         
         int count1=suf1[i];

         if(i+count1<n && suf0[i+count1]>=count1)
      ans++;
       }

        }

// for(int i=0;i<n;i++){
//     System.out.println(suf0[i]+" "+suf1[i]);
// }
        return ans;

    }
}
