package algs.sort;

import java.util.Random;

public class TestSort {

    public static void main(String[] args) {
        int n = 100;
//        Integer[] arr = new Integer[n];
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000);
        }
        Heap heap = new Heap();
        long start = System.currentTimeMillis();
        heap.sort(arr);
        long end = System.currentTimeMillis();
        boolean isSort = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSort = false;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(isSort);
        System.out.println(end - start);
    }

}
