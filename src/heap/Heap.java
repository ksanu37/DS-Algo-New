package heap;

public class Heap {
    private int heapSize;
    private int[] arr;
    private int currentHeapSize;

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
        this.arr = new int[heapSize];
        currentHeapSize = -1;
    }

    public Heap(int heapSize) {
        setHeapSize(heapSize);
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void maxHeapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int largest = i;
        if (l < heapSize && arr[l] > arr[largest])
            largest = l;
        if (r < heapSize && arr[r] > arr[largest])
            largest = r;

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(largest);
        }
    }

    public void insertKey(int val) {
        if (currentHeapSize < heapSize - 1)
            currentHeapSize++;
        else {
            System.out.println("Heap Overflow!");
        }
        arr[currentHeapSize] = val;
        int i = currentHeapSize;
        while(i !=0 && arr[parent(i)] < arr[i]){
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

    public int peek(){
        return arr[0];
    }

    public int removeMax(){
        int res = Integer.MIN_VALUE;
        if(currentHeapSize < 0)
            return res;
        if(currentHeapSize == 0){
            currentHeapSize--;
            return arr[0];
        }

        res = arr[0];
        arr[0] = arr[currentHeapSize];
        currentHeapSize--;
        maxHeapify(0);
        return res;
    }

    public void deleteKey(int i) {
        increaseKey(i, Integer.MAX_VALUE);
        removeMax();
    }

    private void increaseKey(int i, int newVal) {
        arr[i] = newVal;
        while(i!=0 && arr[parent(i)] < arr[i]){
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }
}
