import java.io.*;

public class BOJ_12852 {

	static int N;
	static int[] dp, prev;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		init();
		op();

		sb.append(dp[N]).append('\n');

		while (N >= 1) {
			sb.append(N).append(' ');
			N = prev[N];
		}

		System.out.println(sb);
	}

	static void init() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		prev = new int[N+1];
	}

	static void op() {
		
		for (int k=2; k<=N; k++) {
			int tmp = k-1;
			dp[k] = dp[k-1] + 1;

			if (k % 2 == 0) {
				if (dp[k/2] + 1 < dp[k]) {
					dp[k] = dp[k/2] + 1;
					tmp = k/2;
				}
			} 
			if (k % 3 == 0) {
				if (dp[k/3] < dp[k]) {
					dp[k] = dp[k/3] + 1;
					tmp = k/3;
				}
			}

			prev[k] = tmp;
		}
	}

}