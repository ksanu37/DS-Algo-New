package bitManipulation;

/*
https://leetcode.com/problems/single-number-iii/
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.



Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Solution: Perform an overall XOR on the entire array. From here, we will get the XOR of two single numbers.

Now, check for the first rightmost set bit in the xor. This bit will be set in only one of the two numbers.
Using this bit, divide the array into two groups: one with this bit set, other with this bit unset.
The result will be the xor of these two groups.
 */

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int overAllXor = 0;

        for(int i=0; i<nums.length; i++){
            overAllXor ^= nums[i];      // From here, we will get the xor of two unique numbers;
        }


        int index = 0;

        for(int i=0; i<32; i++){
            if((overAllXor & (1<<i))>0){
                index = i;
                break;
            }
        }

        int firstGroupXor = 0;
        for(int i=0; i<nums.length; i++){
            if((nums[i] & (1<<index))>0)
                firstGroupXor ^= nums[i];
        }

        res[0] = firstGroupXor;
        res[1] = firstGroupXor^overAllXor;
        return res;
    }
}
