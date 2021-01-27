package algs.sort;

public class Bubble {

    public void sort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
//            boolean isSort = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
//                    isSort = false;
                }
            }
//            if (isSort) {
//                break;
//            }
        }
    }

}
