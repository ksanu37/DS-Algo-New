package linkedlist;

import java.util.PriorityQueue;
/*
https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKSortedLists {
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr_end = null;
        PriorityQueue<HeapNode> pq = new PriorityQueue<>();

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(new HeapNode(i, lists[i].val));
                lists[i] = lists[i].next;
            }
        }

        HeapNode curr = null;
        while(!pq.isEmpty()) {
            curr = pq.poll();
            ListNode temp = new ListNode(curr.value);
            if (head == null){
                head = temp;
                curr_end = temp;
            } else {
                curr_end.next = temp;
                curr_end = temp;
            }

            if(lists[curr.x] != null){
                pq.add(new HeapNode(curr.x, lists[curr.x].val));
                lists[curr.x] = lists[curr.x].next;
            }
        }
        return head;
    }
}

class HeapNode implements Comparable<HeapNode> {
    int x;
    int value;

    HeapNode(int x, int value){
        this.x = x;
        this.value = value;
    }

    @Override
    public int compareTo(HeapNode hn){
        if(this.value <= hn.value)
            return -1;
        return 1;
    }
}