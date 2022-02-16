package recursion;

/*
    https://leetcode.com/problems/subsets/

    Given an integer array nums of unique elements, return all possible subsets (the power set).

    The solution set must not contain duplicate subsets. Return the solution in any order.



    Example 1:

    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


    Solution: The idea is to use recursion and backtracking. In every recursion step, we can either choose a number or
    neglect it. On this basis, the subsets will be generated.


 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> currentSubset = new ArrayList<>();  // The list to store current subset
        List<List<Integer>> res = new ArrayList<>();  // The list of lists to store all subsets
        generateSubsets(nums, 0, currentSubset, res);
        return res;
    }

    public void generateSubsets(int[] nums, int currIndex, List<Integer> currentSubset, List<List<Integer>> res){
        if(currIndex == nums.length){
            // if we reach the end of the given array, we have formed a subset by either including or neglecting the numbers
            res.add(new ArrayList<>(currentSubset));
            return;
        }
        generateSubsets(nums, currIndex+1, currentSubset, res);  // Neglecting the number at current Index
        currentSubset.add(nums[currIndex]); // Including the number at current Index
        generateSubsets(nums, currIndex+1, currentSubset, res);
        currentSubset.remove(currentSubset.size()-1); // Removing the last added number for backtracking
    }
}
