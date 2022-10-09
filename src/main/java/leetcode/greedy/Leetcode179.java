package leetcode.greedy;

public class Leetcode179 {

    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }

        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int first = nums[j];
                int second = nums[j + 1];
                int bitLength1 = 10;
                int bitLength2 = 10;
                while (first / 10 > 0) {
                    bitLength1 = bitLength1 * 10;
                    first = first / 10;
                }

                while (second / 10 > 0) {
                    bitLength2 = bitLength2 * 10;
                    second = second / 10;
                }


                if ((long) nums[j] * bitLength2 + nums[j + 1] < (long) nums[j + 1] * bitLength1 + nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode179 leetcode179 = new Leetcode179();
        String res = leetcode179.largestNumber(new int[]{999999998,999999997,999999999});
        System.out.println(res);
    }

}
