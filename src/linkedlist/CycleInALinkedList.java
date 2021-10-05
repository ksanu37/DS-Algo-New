package linkedlist;

/*
https://leetcode.com/problems/linked-list-cycle/
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.


Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).


The idea is to take two pointers: slow and fast, move slow by 1 step and fast by 2 steps.
If there is a cycle in the list, these two pointers will meet at some point.
 */

public class CycleInALinkedList {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p2 != null && p2.next != null) {
            if(p1 == p2)
                return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }
}
