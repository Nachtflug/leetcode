package algorithm;

public class TranslateNum {

    public int translateNum(int num) {
        if (num == 0)
            return 1;
        int[] dp = new int[23];

        int last = 10086;
        int idx = 1;
        dp[0] = 1;
        dp[1] = 1;
        while (num > 0) {
            idx++;
            int cur = num % 10;
            if (cur == 0)
                dp[idx] = dp[idx - 1];
            else if (cur * 10 + last < 25 && idx > 1)
                dp[idx] = dp[idx - 1] + dp[idx - 2];
            else
                dp[idx] = dp[idx - 1];
            num /= 10;
            last = cur;
        }


        return dp[idx];

    }


}
