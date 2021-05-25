package linkedlist;

/*
                https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
==================================================================================================================================================================================
Given a singly linked list, find the middle of the linked list.
For example, if the given linked list is 1->2->3->4->5 then the output should be 3.
If there are even nodes, then there would be two middle nodes,
we need to print the second middle element.
For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.


Solution:  TWO POINTERS
Traverse linked list using two pointers. Move one pointer by one and the other pointers by two.
When the fast pointer reaches the end slow pointer will reach the middle of the linked list.

 */

public class PrintMiddleOfAGivenLinkedList {
    public static Integer run(LinkedList list){
        LinkedList.Node head = list.head;

        if(head == null){
            System.out.println("Empty List");
            return null;
        }
        LinkedList.Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
