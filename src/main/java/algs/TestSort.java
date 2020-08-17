package algs;

import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(1000);
        }
        Merge merge = new Merge();
        merge.sort(arr);
        boolean isSort = true;
        for (int i = 0; i < 99; i++) {
            if (arr[i] > arr[i + 1]) {
                isSort = false;
                break;
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        System.out.println(isSort);
    }
}
