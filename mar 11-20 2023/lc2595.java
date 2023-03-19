// You are given a positive integer n.

// Let even denote the number of even indices in the binary representation of n (0-indexed) with value 1.

// Let odd denote the number of odd indices in the binary representation of n (0-indexed) with value 1.

// Return an integer array answer where answer = [even, odd].


class Solution {
    public int[] evenOddBit(int n) {
        
//         String bin = Integer.toBinaryString(n);
//         int len=bin.length();
//         int even=0;
//         int odd=0;
//         int[] ans=new int[2];
        
//         for(int i=0;i<len;i++){
//             char ch=bin.charAt(i);
            
//             if(ch=='1'){
                
//                 if(i%2==0)
//                     even++;
//                 else
//                     odd++;
//             }else
//                 continue;
//         }
//         ans[0]=even;
//         ans[1]=odd;
        
//         if(n==2){
//             ans[0]=0;
//             ans[1]=1;
//         }
        
//         return ans;
        
        
         String bString = Integer.toBinaryString(n);
         StringBuilder sb=new StringBuilder(bString);
        sb.reverse();
        String s = sb.toString();
        int odd=0,even=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                if(i%2==0) even++;
                else
                    odd++;
            }
        }
        int a[] = new int[2];
        a[0]=even;
        a[1]=odd;
        return a;
    }
}
