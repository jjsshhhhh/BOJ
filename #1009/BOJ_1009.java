import java.io.*;
import java.util.*;

public class BOJ_1009 {

    static int[][] arr = {
        {10}, {1}, {2,4,8,6}, {3,9,7,1}, {4,6},
        {5}, {6}, {7,9,3,1}, {8,4,2,6}, {9,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a %= 10;
            int c = b % arr[a].length - 1;
            if (c == -1) c = arr[a].length - 1;

            sb.append(arr[a][c]).append('\n');
        }

        System.out.println(sb);
    }
}