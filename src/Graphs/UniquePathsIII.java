package Graphs;

/*
https://leetcode.com/problems/unique-paths-iii/
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)


Solution: The idea is to use DFS + Backtracking.
First, get the number of zeros and start point. Now, using this start point, do a dfs in all four directions, marking the point as -1 and
the moment you reach the end point, see if you have exhausted all the zeros. If yes, then you have a unique path return 1,
else 0.

After the dfs is done, mark this cell as 0 again, so that this can be used for other paths {Backtracking}

 */


public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        if(grid.length == 0)
            return 0;

        int zeros = 0;
        int startX = 0, startY = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0)
                    zeros++;
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        return dfs(startX, startY, zeros, grid);
    }

    public int dfs(int startX, int startY, int zeros, int[][] grid){
        if(startX<0 || startX>=grid.length
                || startY<0 || startY>=grid[0].length
                || grid[startX][startY]==-1)
            return 0;

        if(grid[startX][startY] == 2){
            if(zeros == -1)
                return 1;

            return 0;
        }

        grid[startX][startY] = -1;
        zeros--;

        int totalPathsFromHere = dfs(startX+1, startY, zeros, grid)
                + dfs(startX-1, startY, zeros, grid)
                + dfs(startX, startY+1, zeros, grid)
                + dfs(startX, startY-1, zeros, grid) ;

        grid[startX][startY] = 0;

        return totalPathsFromHere;

    }
}
