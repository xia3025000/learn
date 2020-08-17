package leetcode.other;

public class Leetcode299 {

    public String getHint(String secret, String guess) {
        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();
        int n = secretArr.length;
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < n; i++) {
            if (secretArr[i] == guessArr[i]) {
                bull++;
                continue;
            }
            secretCount[secretArr[i] - '0']++;
            guessCount[guessArr[i] - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            cow = cow + Math.min(secretCount[i], guessCount[i]);
        }
        String res = bull + "A" + cow + "B";
        return res;
    }

    public static void main(String[] args) {
        Leetcode299 leetcode299 = new Leetcode299();
        String secret = "1807";
        String guess = "7810";
        String res = leetcode299.getHint(secret, guess);
        System.out.println(res);
    }

}
