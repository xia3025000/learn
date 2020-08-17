package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int n = asteroids.length;
        while (i < n) {
            int right = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(right);
            } else {
                while (!stack.isEmpty()) {
                    int left = stack.pop();
                    if ((left >= 0 && right < 0)
                            || (left > 0 && right <= 0)) {
                        //发生碰撞
                        int lsubr = Math.abs(left) - Math.abs(right);
                        if (lsubr > 0) {
                            right = left;
                            stack.push(right);
                            break;
                        } else if (lsubr < 0) {
                            if (stack.isEmpty() || stack.peek() <= 0) {
                                stack.push(right);
                                break;
                            }
                        }
                    } else {
                        //未发生碰撞
                        stack.push(left);
                        stack.push(right);
                        break;
                    }
                }
            }
            i++;
        }
        if (stack.isEmpty()) {
            return new int[]{};
        }
        List<Integer> resList = new ArrayList<>(stack);
        int[] res = new int[resList.size()];
        for (int j = 0; j < res.length; j++) {
            res[j] = resList.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode735 leetcode735 = new Leetcode735();
        int[] arr = leetcode735.asteroidCollision(new int[]{-2, 1, 1, -2});
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
