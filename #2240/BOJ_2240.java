import java.io.*;
import java.util.*;

public class BOJ_2240 {

    static int T, W, cur = 1;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        init();
        op();

        System.out.println(dp[T][W]);
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken()); // 최대 움직임

        arr = new int[T+1];
        dp = new int[T+1][W+1];

        for (int i=1; i<=T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void op() {

        for (int t=1; t<=T; t++) {
            dp[t][0] = dp[t-1][0];
            if (arr[t] == cur) dp[t][0] += 1;
        }

        for (int w=1; w<=W; w++) {
            cur ^= 3;

            for (int t=1; t<=T; t++) {
                if (arr[t] == cur)
                    dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t][w-1] + 1);
                else
                    dp[t][w] = Math.max(dp[t-1][w], dp[t][w-1]);
            }
        }
    }

}