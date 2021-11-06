package Graphs;

/*

https://leetcode.com/problems/word-search/
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"

Solution: Backtracking + DFS

Optimization: Make a dfs call only when the adjacent character matches with the character at the next index in the string
 */

public class WordSearch {
    public int m, n;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0)
            return false;
        m = board.length;
        n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0) && dfs(i, j, board, word, 0))
                    return true;
            }
        }

        return false;
    }


    public boolean dfs(int i, int j, char[][]board, String word, int index){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '/')
            return false;

        char currentChar = board[i][j];
        board[i][j] = '/';

        if(index == word.length()-1)
            return true;


        if(isSafe(i+1, j) && board[i+1][j] == word.charAt(index+1) && dfs(i+1, j, board, word, index+1)){
            board[i][j] = currentChar;
            return true;
        }

        if(isSafe(i-1, j) && board[i-1][j] == word.charAt(index+1) && dfs(i-1, j, board, word, index+1)){
            board[i][j] = currentChar;
            return true;
        }
        if(isSafe(i, j+1) &&
                board[i][j+1] == word.charAt(index+1) &&
                dfs(i, j+1, board, word, index+1)){

            board[i][j] = currentChar;
            return true;
        }
        if(isSafe(i, j-1) &&
                board[i][j-1] == word.charAt(index+1) &&
                dfs(i, j-1, board, word, index+1)){

            board[i][j] = currentChar;
            return true;
        }

        board[i][j] = currentChar;
        return false;
    }

    public boolean isSafe(int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }
}
