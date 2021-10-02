package arrays;

import java.util.ArrayList;

/*

LeetCode Link: https://leetcode.com/problems/pascals-triangle/
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

 */

public class PascalsTriangle {
    public static int mod = 1000000007;
    public static ArrayList<Integer> getNthRowOfPascalsTriangle(int n){
        ArrayList<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        if(n==0)
            return currentRow;

        ArrayList<Integer> prev = getNthRowOfPascalsTriangle(n-1);

        for(int i=1; i<prev.size(); i++){
            currentRow.add((prev.get(i)%mod + prev.get(i-1)%mod)%mod);
        }
        currentRow.add(1);
        return currentRow;
    }

    public static void getNthRowOfPascalsTriangleUsingCombination(int n){
        long prev = 1;
        long mod = 1000000007;
        System.out.print(prev + " ");
        // Nc0, Nc1, Nc2, ........, NcN --> Ncr = Ncr-1 *(n-r+1) / r
        for(int i=1; i<=n; i++){
            long cal = ((prev) * (n-i+1));
            long curr = (cal/i)%mod;
            System.out.print(curr + " ");
            prev = curr;
        }
    }
}
