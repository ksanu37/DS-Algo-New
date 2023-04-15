package heap;

import java.util.PriorityQueue;

public class HeapUsingPriorityQueue {

    private static PriorityQueue<HeapNode> pq = new PriorityQueue<>();
    public static void addKey(int val){
        HeapNode heapNode = new HeapNode(val);
        pq.add(heapNode);
    }

    public static int getMax() {
        return pq.peek().getValue();
    }

    public static int removeMax() {
        return pq.poll().getValue();
    }

    public static void printCurrentHeap() {
        while(!pq.isEmpty()){
            System.out.print(removeMax() +" ");
        }
    }
}

