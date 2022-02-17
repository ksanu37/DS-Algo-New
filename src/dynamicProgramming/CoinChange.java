package dynamicProgramming;

/*
https://leetcode.com/problems/coin-change/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1


Solution: Maintain an array of size amount+1
          Iterate from 1 and go uptil amount, see if the (amount- coins[j]) is already made,
          if yes, get the min out of all the possible (amount - coins[j])
 */

import java.util.Arrays;

public class CoinChange {

    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[]res = new int[amount+1];
        Arrays.fill(res, amount+1);
        res[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i-coins[j]>=0){ // if i-coins[j] >=0, the coin change for this value has already been calculated,
                    // to reach i, you need 1 + (i-coins[j]) coins, this is already stored in res[i-coins[j]
                    res[i] = Math.min(res[i] , 1+ res[i-coins[j]]);
                }
            }
        }

        return res[amount] == amount+1? -1: res[amount];
    }
}
