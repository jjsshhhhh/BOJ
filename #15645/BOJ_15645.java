import java.io.*;
import java.util.*;

public class BOJ_15645 {

    static int N, max, min;
    static int[][] arr;
    static int[][][] ans;

    public static void main(String[] args) throws IOException {
        
        init();
        op();
        print();
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        ans = new int[N][3][2];

        for (int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int k=0; k<3; k++) {
                arr[n][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=0; k<3; k++) {
            ans[0][k][0] = arr[0][k];
            ans[0][k][1] = arr[0][k];
        }
    }

    static void op() {

        for (int n=1; n<N; n++) {
            for (int k=0; k<3; k++) {

                ans[n][k][0] = arr[n][k] + ans[n-1][k][0];
                ans[n][k][1] = arr[n][k] + ans[n-1][k][1];
                
                if (k >= 1) {
                    ans[n][k][0] = Math.max(ans[n][k][0], arr[n][k] + ans[n-1][k-1][0]);
                    ans[n][k][1] = Math.min(ans[n][k][1], arr[n][k] + ans[n-1][k-1][1]);
                }

                if (k <= 1) {
                    ans[n][k][0] = Math.max(ans[n][k][0], arr[n][k] + ans[n-1][k+1][0]);
                    ans[n][k][1] = Math.min(ans[n][k][1], arr[n][k] + ans[n-1][k+1][1]);
                }
            }
        }

        max = ans[N-1][0][0];
        min = ans[N-1][0][1];
        for (int k=1; k<3; k++) {
            max = Math.max(max, ans[N-1][k][0]);
            min = Math.min(min, ans[N-1][k][1]);
        }    
    }

    static void print() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(max).append(' ').append(min);
        System.out.println(sb);
    }
}