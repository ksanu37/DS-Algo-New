package heap;

import java.util.PriorityQueue;


/*
https://leetcode.com/problems/median-of-two-sorted-arrays/description/

Using two mean hips, we keep extracting the min elements from the arrays until we reach the mid values.
 */
public class MeadianOfTwoSortedArrays {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            PriorityQueue<Integer> leftPq = new PriorityQueue<>();
            addElementsToMinHeap(nums1, leftPq);
            PriorityQueue<Integer> rightPq = new PriorityQueue<>();
            addElementsToMinHeap(nums2, rightPq);
            int left = (m + n)/2;
            if ((m + n) % 2 == 1) {
                int ele = getMinElement(leftPq, rightPq, left+1);
                return 2.0 * ele / 2.0;
            } else {
                int leftEle = getMinElement(leftPq, rightPq, left);
                int rightEle = getNextMin(leftPq, rightPq);
                return (leftEle + rightEle)/ 2.0;
            }

        }

        private static void addElementsToMinHeap(int[] nums, PriorityQueue<Integer> pq){
            for(int i=0; i<nums.length; i++)
                pq.add(nums[i]);
        }

        private static int getMinElement(PriorityQueue<Integer> leftPq, PriorityQueue<Integer>rightPq, int index) {
            int i = 0;
            int ele = 0;
            while(i!=index){
                ele = getNextMin(leftPq, rightPq);
                i++;
            }

            return ele;
        }

        private static int getNextMin(PriorityQueue<Integer> leftPq, PriorityQueue<Integer>rightPq) {
            int ele = 0;
            if(!leftPq.isEmpty() && !rightPq.isEmpty()){
                int leftMin = leftPq.peek();
                int rightMin = rightPq.peek();
                if(leftMin <= rightMin) {
                    ele = leftPq.poll();
                } else {
                    ele = rightPq.poll();
                }
            } else if (leftPq.isEmpty()){
                ele = rightPq.poll();
            } else if (rightPq.isEmpty()){
                ele = leftPq.poll();
            }

            return ele;
        }
}
