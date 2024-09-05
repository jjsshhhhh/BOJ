import java.io.*;
import java.util.*;

public class BOJ_5569 {

    static int MOD = 100000;
    static int w, h;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {

        init();
        op();
        print();
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // dp[H][W][D][P]
        // D : 현재 이동 방향  0-북쪽, 1-동쪽
        // P : 방향 변경 여부  0-변경X, 1-변경O 
        dp = new int[h+1][w+1][2][2];
    }

    static void op() {

        // 가로 - 동쪽 이동만 가능
        for (int j=2; j<=w; j++) dp[1][j][1][0] = 1;
        // 세로 - 북쪽 이동만 가능
        for (int i=2; i<=h; i++) dp[i][1][0][0] = 1;

        for (int i=2; i<=h; i++) {
            for (int j=2; j<=w; j++) {
                // 방향 변경 X
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % MOD;
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % MOD;
                // 방향 변경 O
                dp[i][j][0][1] = dp[i-1][j][1][0];
                dp[i][j][1][1] = dp[i][j-1][0][0];
            }
        }
    }

    static void print() {

        int result = 0;

        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                result += dp[h][w][i][j];
            }
        }

        System.out.println(result % MOD);
    }

}