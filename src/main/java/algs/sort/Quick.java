package algs.sort;

public class Quick {

//    public void sort(int[] arr) {
//        sort(arr, 0, arr.length - 1);
//    }
//
//    private void sort(int[] arr, int lo, int hi) {
//        if (lo < hi) {
//            int partition = partition(arr, lo, hi);
//            sort(arr, lo, partition - 1);
//            sort(arr, partition + 1, hi);
//        }
//    }
//
//    private int partition(int[] arr, int lo, int hi) {
//        int i = lo;
//        int j = hi + 1;
//        int flag = arr[lo];
//        while (true) {
//            while (++i <= hi && arr[i] < flag) {
//            }
//            while (--j >= lo && arr[j] > flag) {
//            }
//            if (i >= j) {
//                break;
//            }
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//        arr[lo] = arr[j];
//        arr[j] = flag;
//        return j;
//    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = partition(arr, lo, hi);
            sort(arr, lo, mid - 1);
            sort(arr, mid + 1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int flag = arr[lo];
        while (true) {
            while (++i <= hi && arr[i] < flag) {
            }
            while (--j >= lo && arr[j] > flag) {
            }
            if (i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[lo] = arr[j];
        arr[j] = flag;
        return j;
    }

}
