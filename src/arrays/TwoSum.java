package arrays;

import java.util.HashMap;

/*

https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].


Solution: The idea is to maintain a map of numbers in the array with their indices,
    as we go along we keep finding if there is a number in the map,
    which sums up, with the current number, to the target
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] solution = new int[2];

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                solution[0] = i;
                solution[1] = map.get(target-nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return solution;
    }
}
