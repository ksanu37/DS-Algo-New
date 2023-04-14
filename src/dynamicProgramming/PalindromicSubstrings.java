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

    /**
     *
     * @param s
     * @return length of the largest palindromic subsequence of the String s
     *
     * Follow the same procedure to check for a palindromic subsequence, here if we encounter start and end
     * characters as same, the length of the largest subsequence till here is 2 + matrix[i+1][j-1]
     * otherwise, the length will be calculated by getting the max (including char at i once and char at j once)
     * --> Math.max(matrix[i+1][j], matrix[i][j-1])
     */
    public int longestPalindromicSubsequence(String s) {
        int len = s.length();
        int [][] matrix = new int[len][len];
        for(int gap = 0; gap < len; gap++){
            for(int i=0, j = i + gap; j < len; i++, j++){
                if (gap == 0){
                    matrix[i][j] = 1;
                } else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        matrix[i][j] = 2;
                    } else {
                        matrix[i][j] = 1;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        // found start and end same, length = 2 + maxLen in enclosed String
                        matrix[i][j] = 2 + matrix[i+1][j-1];
                    } else {
                        // maxLen will be either including start or including end, since both don't match and can't be included
                        matrix[i][j] = Math.max(matrix[i][j-1], matrix[i+1][j]);
                    }
                }
            }
        }

        return matrix[0][len-1];
    }
}
