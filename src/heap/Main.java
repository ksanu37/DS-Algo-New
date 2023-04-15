package heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insertKey(10);
        heap.insertKey(12);
        heap.insertKey(9);
        heap.insertKey(5);
        heap.insertKey(15);
        heap.insertKey(14);

        System.out.println("Current Max Value = " + heap.peek());
        System.out.println("Removing Max Value");
        heap.removeMax();
        System.out.println("Current Max Value = " + heap.peek());
        heap.insertKey(77);
        System.out.println("Inserted 77");
        System.out.println("Current Max Value = " + heap.peek());

        HeapUsingPriorityQueue.addKey(23);
        HeapUsingPriorityQueue.addKey(21);
        HeapUsingPriorityQueue.addKey(44);
        HeapUsingPriorityQueue.addKey(32);
        HeapUsingPriorityQueue.addKey(87);
        HeapUsingPriorityQueue.addKey(12);

        HeapUsingPriorityQueue.printCurrentHeap();
    }
}
