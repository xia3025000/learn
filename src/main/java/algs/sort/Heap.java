package algs.sort;

public class Heap {

    public void sort(int[] arr) {
        int n = arr.length;

        // heapify phase
        for (int k = (n - 1) / 2; k >= 0; k--) {
            sink(arr, k, n - 1);
        }

        // sortdown phase
        int k = n - 1;
        while (k >= 0) {
            int temp = arr[0];
            arr[0] = arr[k];
            arr[k] = temp;
            k--;
            sink(arr, 0, k);
        }
    }

    private void sink(int[] arr, int k, int n) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            if (j < n && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            int temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;
            k = j;
        }
    }
}
