package linkedlist;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:

Input: head = [1,1,2]
Output: [1,2]

The idea is to fix the head first, and the recursively solve for other nodes

 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;

        while(head.next!=null && head.next.val == head.val)
            head = head.next;   //Fixing the head

        head.next = deleteDuplicates(head.next);

        return head;
    }
}
