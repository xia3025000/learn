package algs;

public class Fibonacci {

    public static void main(String[] args) {
        int k = 5 - 2;
        int s1 = 1;
        int s2 = 1;
        for (int i = 0; i < k; i++) {
            int temp = s1;
            s1 = s2;
            s2 = temp + s2;
        }
        System.out.println(s2);
    }

}
