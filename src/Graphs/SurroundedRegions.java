package Graphs;


/*

https://leetcode.com/problems/surrounded-regions/

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:

Input: board = [["X"]]
Output: [["X"]]

Solution: Look for 'O' on the boundaries and mark all the Os connected to them horizontally/Vertically,
recursively using dfs. Finally replace all these marked fields with O and the rest with X

 */
public class SurroundedRegions {
    public int[] x_visit = {-1, 0, 0, 1};
    public int[] y_visit = {0, 1, -1, 0};

    public void solve(char[][] board) {
        if(board.length == 0)
            return;

        boolean visited[][] = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if((i == 0 || i == board.length-1 || j==0 || j==board[0].length - 1)
                        && !visited[i][j] && board[i][j] == 'O'){
                    dfs(i, j, visited, board);
                }
            }
        }


        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
                if(board[i][j] == '?')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(int m, int n, boolean visited[][], char board[][]){
        visited[m][n] = true;
        board[m][n] = '?';

        for(int i=0; i<4; i++){
            if(isSafe(m+x_visit[i], n+y_visit[i], visited, board) && !visited[m+x_visit[i]][n+y_visit[i]]){
                dfs(m+x_visit[i], n+y_visit[i], visited, board);
            }
        }
    }

    public boolean isSafe(int m, int n, boolean visited[][], char board[][]){
        return m>=0 && n>=0 && m<board.length && n<board[0].length && !visited[m][n] && board[m][n] == 'O';
    }
}
