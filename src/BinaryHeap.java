import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryHeap {

    private final List<Integer> list;

    public BinaryHeap(Integer [] array){
        list = new ArrayList<>(Arrays.asList(array));
        for(int i = 0; i < list.size(); i++){
            sortTheHeap(heapSize() - 1 - i);
        }
    }

    public void printBinaryHeap(){
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public List<Integer> getList(){
        return list;
    }

    public int heapSize(){
        return list.size();
    }

    public void addNewElement(int element){
        list.add(element);
        int i = heapSize() - 1;
        int parent = (i - 1) / 2;
        int temp;

        while(i > 0 && list.get(i) > list.get(parent)){
            temp = list.get(i);
            list.set(i, list.get(parent));
            list.set(parent,temp);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public void heapSort(){
        for(int i = 0; i < list.size(); i++){
            getMax();
        }
    }

    public void sortTheHeap(int i){
        int leftChild;
        int rightChild;
        int largestChild;
        int temp;

        while(true){
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < heapSize() && list.get(leftChild) > list.get(largestChild)){
                largestChild = leftChild;
            }
            if (rightChild < heapSize() && list.get(rightChild) > list.get(largestChild)){
                largestChild = rightChild;
            }
            if (largestChild == i){
                break;
            }
            temp = list.get(i);
            list.set(i, list.get(largestChild));
            list.set(largestChild, temp);
            i = largestChild;
        }
    }

    public int getMax(){
        sortTheHeap(0);
        int maximum = list.get(0);
        list.set(0, list.get(heapSize() - 1));
        list.remove(heapSize() - 1);
        return maximum;
    }
}
