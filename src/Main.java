import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        BinaryHeap bh = new BinaryHeap(arr);
        for(int i = 0; i < arr.length; i++){
            arr[arr.length - i - 1] = bh.getMax();
        }
        for (int element: arr) {
            System.out.print(element + " ");
        }
    }
}
