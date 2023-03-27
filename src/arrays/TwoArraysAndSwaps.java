package arrays;

import java.util.Arrays;

/*
        https://codeforces.com/problemset/problem/1353/B
 */
public class TwoArraysAndSwaps {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {4, 4, 5, 4};
        int k = 4;
        Arrays.sort(a);  // 5, 5, 5, 6, 6   O(nlogn)
        Arrays.sort(b); // 1, 2, 3, 4, 5    O(nlogn)

        int sum = 0;
        for(int i=0; i<a.length; i++){
            sum += a[i];
        }
        for(int i= 0; i<k; i++) {
            if(b[b.length-1-i] - a[i] > 0){
                sum += (b[b.length-1-i] - a[i]);
            } else
                break;
        }
        System.out.println(sum);
    }
}
