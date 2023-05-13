// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence 
// of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of 
// words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

import java.util.*;
public class wordladder {
    
    class Pair{
        String str;
        int num;

        Pair(String str,int num){
            this.str=str;
            this.num=num;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> queue=new LinkedList<>();
        Set<String> st=new HashSet<>();

        int len=wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }

        queue.add(new Pair(beginWord,1));
        while(queue.size()>0){
         String word=queue.peek().str;
         int val=queue.peek().num;
         queue.remove();

         if(word.equals(endWord))
         return val;

         for(int i=0;i<word.length();i++){
             for(char ch = 'a'; ch <= 'z'; ch++){
                   
                     char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                   
                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        queue.add(new Pair(replacedWord, val + 1));
                    }
             }
         }

        }

        return 0;


    }
}
