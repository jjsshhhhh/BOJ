import java.io.*;
import java.util.*;

public class BOJ_14921 {

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {

        init();
        
        System.out.println(op());
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int n=0; n<N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }
    }

    static int op() {

        int left = 0;
        int right = N-1;

        int result = 200000001;

        while (left < right) {
            int sum = A[left] + A[right];
            result = (Math.abs(sum) < Math.abs(result)) ? sum : result;

            if (sum > 0) right--;
            else left++;
        }

        return result;
    }

}