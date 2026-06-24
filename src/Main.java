import linkedlist.LinkedList;
import linkedlist.PrintMiddleOfAGivenLinkedList;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {};
//        LinkedList list = LinkedList.convertArrayToLinkedList(arr);
//        LinkedList.printList(list);
//        System.out.println(PrintMiddleOfAGivenLinkedList.run(list))

        int[] nums1 = {1, 3, 5, 6, 7, 8, 9};
        int[] nums2 = {2};

        int m = nums1.length;
        int n = nums2.length;

        PriorityQueue<Integer> leftPq = new PriorityQueue<>();
        addElementsToMinHeap(nums1, leftPq);
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();
        addElementsToMinHeap(nums2, rightPq);

//        rightPq.add(3);
        int left = (m + n)/2;
        if ((m + n) % 2 == 1) {
            int ele = getMinElement(leftPq, rightPq, left+1);
            System.out.println( 2.0 * ele / 2.0);
        } else {
            System.out.println("Getting left Element");
            int leftEle = getMinElement(leftPq, rightPq, left);
            System.out.println("Left Element = " + leftEle);
            System.out.println("Getting right Element");
            int rightEle = getNextMin(leftPq, rightPq);
            System.out.println("Right Element = " + rightEle);

            System.out.println("************");
            System.out.println( (leftEle + rightEle)/ 2.0);
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
            System.out.println("Comparing " + leftMin + "-->" + rightMin);
            if(leftMin <= rightMin) {
                System.out.println("Left is min, polling " + leftMin);
                ele = leftPq.poll();
            } else {
                ele = rightPq.poll();
                System.out.println("Right is min, polling " + rightMin);
            }
        } else if (leftPq.isEmpty()){
            ele = rightPq.poll();
        } else if (rightPq.isEmpty()){
            ele = leftPq.poll();
        }

        return ele;
    }
}