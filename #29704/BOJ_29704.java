import java.io.*;
import java.util.*;

public class BOJ_29704 {

    static int N, T, total;
    static int[] D, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        init();
        knapsack();
        print();
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 문제의 개수
        T = Integer.parseInt(st.nextToken()); // 남은 제출 기한

        D = new int[N+1];
        M = new int[N+1];
        dp = new int[N+1][T+1];

        for (int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            D[n] = Integer.parseInt(st.nextToken()); // 문제 푸는 데 걸리는 일수
            M[n] = Integer.parseInt(st.nextToken()); // 해당 문제의 벌금
            total += M[n];
        }
    }

    static void knapsack() {

        for (int n=1; n<=N; n++) {
            for (int t=1; t<=T; t++) {
                if (D[n] > t)
                    dp[n][t] = dp[n-1][t];
                else
                    dp[n][t] = Math.max(dp[n-1][t], dp[n-1][t-D[n]] + M[n]);
            }
        }
    }

    static void print() {

        System.out.println(total - dp[N][T]);
    }

}


/*

프로그래밍 과제
문제 N개, 제출 기한 T일

제출 기한 내에 제출 못 하면 - 문제마다 정해진 벌금
벌금 총 금액이 최소가 되도록 문제 풀려 함

출력: 혜민이가 내야 하는 벌금의 최소 금액
     T일이 지났을 때, 제출하지 못한 문제별 벌금의 합
     기한 내 모든 문제 해결 가능 0

 */