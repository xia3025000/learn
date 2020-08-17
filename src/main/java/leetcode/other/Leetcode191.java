package leetcode.other;

public class Leetcode191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        int mask = 1;
        while (n > 0) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode191 leetcode191 = new Leetcode191();
        int res = leetcode191.hammingWeight(0b11111111111111111111111111111101);
        System.out.println(res);
    }

}
