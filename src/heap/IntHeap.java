package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class IntHeap {
    private List<Integer> heap ;

    public IntHeap(){
        heap = new ArrayList<>();
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int leftChild(int index){
        return 2*index+1;
    }
    private int rightChild(int index){
        return 2*index+2;
    }

    public void offer(int val) {
      heap.add(val);
      bubbleUp(heap.size()-1);
    }

    private void bubbleUp(int currIndex) {

        while(currIndex > 0){
            int parentIndex = parent(currIndex);
            if(heap.get(currIndex) >=heap.get(parentIndex)) break;
            swap(currIndex, parentIndex);
            currIndex = parentIndex;
        }
    }

    private void swap(int current, int parent) {
        int temp = heap.get(current);
        heap.set(current, heap.get(parent));
        heap.set(parent, temp);
    }
    public int poll(){

        if(heap.isEmpty())
            throw new NoSuchElementException("Heap is empty");
        int minValue = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        bubbleDown(0);
        return minValue;
    }

    private void bubbleDown(int index){

        while(true){
            int smallest = index;
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            if(leftIndex < heap.size() && heap.get(leftIndex) < heap.get(smallest)){
                smallest = leftIndex;
            }
            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(smallest)){
                smallest = rightIndex;
            }
            if(smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    public int peek(){
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap.get(0);
    }

    public int size(){
        return heap.size();
    }

    public static void main(String[] args) {
        IntHeap intHeap = new IntHeap();
        intHeap.offer(4);
        intHeap.offer(9);
        intHeap.offer(1);
        intHeap.offer(2);
        intHeap.offer(3);

        System.out.println("Heap Elements: ");
        while(!intHeap.isEmpty()){
            System.out.println(intHeap.poll());
        }
    }

    private boolean isEmpty() {
        return heap.isEmpty();
    }

}
