package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val < 0) {
                    j++;
                } else if (val > 0) {
                    k--;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(list);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (k > j && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode15 leetcode15 = new Leetcode15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(leetcode15.threeSum(nums));
    }

}
