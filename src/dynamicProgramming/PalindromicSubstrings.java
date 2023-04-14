package dynamicProgramming;


/*
https://leetcode.com/problems/palindromic-substrings/description/

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.


Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Solution: Maintain a 2-D Array, dp[i][j] i -> starting point of Substring, j -> end point of substring.

Start filling the upper triangle (0,0) , (1,1)
and then (0, 1), (1, 2) and so on

the idea is that if the start and end characters of a substring are same and the substring enclosed
by these two chars (substring starting from i+1, ending at j-1)
is a palindrome then this is also a palindrome.


 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int count = 0;
        for(int g=0; g < s.length(); g++) {
            for(int i=0, j = i+g; j < s.length(); i++, j++) {
                if(g == 0) {
                    dp[i][j] = 1;
                    count++;
                } else if (g == 1) {
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        count++;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if ((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                        count++;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return count;
    }
}
