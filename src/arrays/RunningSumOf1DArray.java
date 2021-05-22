package arrays;


/*
                LeetCode: https://leetcode.com/problems/running-sum-of-1d-array/
=========================================================================================
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
 */

public class RunningSumOf1DArray {

    public static int[] runningSum(int[] nums) {
        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }

        return nums;
    }
}
