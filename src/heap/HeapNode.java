package heap;

public class HeapNode implements Comparable<HeapNode> {

    private int value;

    public HeapNode(int value){
        this.value = value;
    }

    @Override
    public int compareTo(HeapNode hn) {
        if(this.value >= hn.value)
            return -1;
        return 1;
    }

    public int getValue() {
        return value;
    }
}
