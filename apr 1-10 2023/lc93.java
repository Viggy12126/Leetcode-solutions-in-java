

// A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
// Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

class Solution {

    public void helper(String s,String curr,List<String> ans,int dots,int ind){

        if(dots==4 && ind==s.length()){
            ans.add(curr.substring(0,curr.length()-1));

            return;
        }

        if(dots>4)
        return;

       for(int i=ind;i<Math.min((ind+3),s.length());i++){
            if(Integer.parseInt(s.substring(ind,i+1))<256 &&(i==ind || s.charAt(ind)!='0')){
                // System.out.println(curr+s.substring(ind,i+1)+".");
       helper(s,curr+s.substring(ind,i+1)+".",ans,dots+1,i+1);

            }
        }
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> ans=new ArrayList<>();
        helper(s,"",ans,0,0);

        return ans;
        
    }
}