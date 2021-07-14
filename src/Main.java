import linkedlist.LinkedList;
import linkedlist.PrintMiddleOfAGivenLinkedList;

public class Main {
    public static void main(String[] args) {
        int[] arr = {};
        LinkedList list = LinkedList.convertArrayToLinkedList(arr);
        LinkedList.printList(list);
        System.out.println(PrintMiddleOfAGivenLinkedList.run(list));

    }
}