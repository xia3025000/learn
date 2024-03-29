package algs.sort;

public class Insertion {

//    public void sort(Integer[] arr) {
//        int n = arr.length;
//
//        for (int i = 1; i < n; i++) {
//            int j = i;
//            int flag = arr[j];
//            for (; j > 0 && flag < arr[j - 1]; j--) {
//                arr[j] = arr[j - 1];
//            }
//            arr[j] = flag;
//        }
//    }

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int flag = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > flag; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = flag;
        }
    }
}
