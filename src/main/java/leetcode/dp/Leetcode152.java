package leetcode.dp;

public class Leetcode152 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxCurr = nums[0];
        int minCurr = nums[0];
        int max = Math.max(Integer.MIN_VALUE, nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                maxCurr = 0;
                minCurr = 0;
            } else {
                int lastMaxTemp = maxCurr;
                int lastMinTemp = minCurr;
                maxCurr = Math.max(nums[i], Math.max(lastMaxTemp * nums[i], lastMinTemp * nums[i]));
                minCurr = Math.min(nums[i], Math.min(lastMaxTemp * nums[i], lastMinTemp * nums[i]));
            }
            max = Math.max(maxCurr, max);
        }
        return Math.max(max, maxCurr);
    }

    public int maxProduct3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //包含当前值对maxArr[],和包含当前值对minArr[]
        int n = nums.length;
        int maxCurr = nums[0];
        int minCurr = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                maxCurr = 0;
                minCurr = 0;
            } else {
                int lastMax = maxCurr;
                int lastMin = minCurr;
                maxCurr = Math.max(nums[i], Math.max(lastMax * nums[i], lastMin * nums[i]));
                minCurr = Math.min(nums[i], Math.min(lastMax * nums[i], lastMin * nums[i]));
            }
            max = Math.max(maxCurr, max);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int maxCurr = nums[0];
        int minCurr = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                maxCurr = 0;
                minCurr = 0;
            } else {
                maxCurr = Math.max(nums[i], Math.max(maxCurr * nums[i], minCurr * nums[i]));
                minCurr = Math.min(nums[i], Math.min(maxCurr * nums[i], minCurr * nums[i]));
            }
            max = Math.max(maxCurr, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode152 leetcode152 = new Leetcode152();
        int[] nums = {2, 3, -2, 4};
        int res = leetcode152.maxProduct(nums);
        System.out.println(res);
//        int res2 = leetcode152.maxProduct2(nums);
//        System.out.println(res2);
    }

}
