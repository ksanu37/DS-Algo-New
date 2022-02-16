package linkedlist;

/*
    https://leetcode.com/problems/swap-nodes-in-pairs/
    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

    Example 1:
    Input: head = [1,2,3,4]
    Output: [2,1,4,3]

    Solution: Use Recursion and swap in pairs
 */

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return head;
        if(head.next == null)
            return head;

        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
    }
}
