package algs;

public class Merge {

    private int[] aux = null;
    public void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }
        int i = lo;
        int j = mid + 1;
        int k = lo;
        while (k <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > hi) {
                arr[k++] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }
    }

}
