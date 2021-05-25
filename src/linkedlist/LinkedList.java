package linkedlist;

public class LinkedList {
    Node head;
     static class Node {
        int val;
        Node next;
        public Node(int x){
            this.val = x;
            this.next = null;
        }
    }

    public static void printList(LinkedList list){
         Node head = list.head;
         if(head == null){
             System.out.println("Empty List");
             return;
         }

         Node temp = head;
         while(temp != null){
             System.out.print(temp.val + " ");
             temp = temp.next;
         }
    }

    public static LinkedList convertArrayToLinkedList(int[] arr){
        LinkedList list = new LinkedList();
        LinkedList.Node head = list.head;
        int len = arr.length;

        for(int i=0; i<len; i++){
            if(head == null){
                head = new LinkedList.Node(arr[i]);
            } else {
                LinkedList.Node node = new LinkedList.Node(arr[i]);
                node.next = head;
                head = node;

            }
        }
        list.head = head;
        return list;
    }
}
