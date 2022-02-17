package recursion;

/*
https://leetcode.com/problems/combination-sum-ii/


Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.



Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]


Solution: Recursion and Backtracking

       Sort the array to avoid duplicates.
       Once an element is selected, the duplicates after that index are to be ignored, as they will be covered in further iterations

       if (i > currentIndex && (candidates[i] == candidates[i - 1])) continue;  --> This takes care of no duplication

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
        public List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if(candidates.length == 0)
                return res;

            List<Integer> currentCombination = new ArrayList<>();
            Arrays.sort(candidates);
            getCombinations(candidates, 0, target, currentCombination);

            return res;
        }

        public void getCombinations(int[] candidates, int currentIndex, int target, List<Integer> currentCombination) {
            if (target < 0) return;
            if (target == 0) {
                res.add(new ArrayList(currentCombination));
                return;
            }

            for (int i = currentIndex; i < candidates.length; i++) {
                if (i > currentIndex && (candidates[i] == candidates[i - 1])) continue;
                else {
                    currentCombination.add(candidates[i]);
                    getCombinations(candidates, i + 1, target - candidates[i], currentCombination);
                    currentCombination.remove(currentCombination.size() - 1);
                }
            }
        }
}
