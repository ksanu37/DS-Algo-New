package linkedlist;
/*
https://leetcode.com/problems/reverse-linked-list/
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

The idea is to use the recursion stack to maintain the current node. Iterate through the whole list and maintain the
reversedHead, manipulate the links and return the reversedHead.

head.next.next = head --> Interchanges the links
 */

public class ReverseALinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode reversedHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
}
