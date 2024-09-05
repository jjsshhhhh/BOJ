import java.io.*;

public class BOJ_17213 {

    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        init();
        op();

        System.out.println(dp[M][N]);
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); // 과일 종류 수
        M = Integer.parseInt(br.readLine()); // 훔치려 하는 과일 개수

        dp = new int[M+1][N+1];
    }

    static void op() {
        for (int n=1; n<=N; n++) {
            for (int m=1; m<=M; m++) {
                if (m == n || n == 1) dp[m][n] = 1;
                else {
                    for (int k=n-1; k<=m-1; k++) dp[m][n] += dp[k][n-1];
                }
            }
        }
    }

}