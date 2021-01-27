package newcoder;

import java.util.*;

public class TwoSortedArraySumTopK {

    static class Node {
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int K = sc.nextInt();
//        Integer[] arr1 = new Integer[N];
//        Integer[] arr2 = new Integer[N];
//        for (int i = 0; i < N; i++) {
//            arr1[i] = sc.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            arr2[i] = sc.nextInt();
//        }
        List<Integer> res = new ArrayList<>();
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] arr2 = new Integer[]{3, 5, 7, 9, 11};

        int N = arr1.length;
        int K = 25;

//        Arrays.sort(arr1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        Arrays.sort(arr2, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });

        for (int i = 0; i < N / 2; i++) {
            int temp = arr1[i];
            arr1[i] = arr1[N - i - 1];
            arr1[N - i - 1] = temp;
        }

        for (int i = 0; i < N / 2; i++) {
            int temp = arr2[i];
            arr2[i] = arr2[N - i - 1];
            arr2[N - i - 1] = temp;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return arr1[o2.x] + arr2[o2.y] - arr1[o1.x] - arr2[o1.y];
            }
        });

//        boolean[][] visited = new boolean[N][N];
        int[] visitX = new int[N];
        int[] visitY = new int[N];
        for (int i = 0; i < N; i++) {
            visitX[i] = -1;
            visitY[i] = -1;
        }

        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            visitX[curr.x] = curr.y;
            visitY[curr.y] = curr.x;
//            visited[curr.x][curr.y] = true;
            res.add(arr1[curr.x] + arr2[curr.y]);
//            System.out.println(curr);
            if (K == res.size()) {
                break;
            }
            if (curr.x + 1 < N) {
//                if (curr.y == 0 || visited[curr.x + 1][curr.y - 1]) {
//                    queue.add(new Node(curr.x + 1, curr.y));
//                }
                if (curr.y == 0 || visitX[curr.x + 1] == curr.y - 1) {
                    queue.add(new Node(curr.x + 1, curr.y));
                }
            }
            if (curr.y + 1 < N) {
//                if (curr.x == 0 || visited[curr.x - 1][curr.y + 1]) {
//                    queue.add(new Node(curr.x, curr.y + 1));
//                }
                if (curr.x == 0 || visitY[curr.y + 1] == curr.x - 1) {
                    queue.add(new Node(curr.x, curr.y + 1));
                }
            }
        }

        System.out.println(res);
    }

}
