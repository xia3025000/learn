package algs.sort;

import java.util.Random;

public class TestSort {

    public static void main(String[] args) {
        Integer[] arr = new Integer[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(1000);
        }
        Bubble bubble = new Bubble();
        bubble.sort(arr);
        boolean isSort = true;
        for (int i = 0; i < 99; i++) {
            if (arr[i] > arr[i + 1]) {
                isSort = false;
            }
        }
        System.out.println(isSort);
        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
