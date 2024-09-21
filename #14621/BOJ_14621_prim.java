import java.io.*;
import java.util.*;

public class BOJ_14621_prim {

    static int N, M, cnt = 0, ans = 0;
    static boolean[] isVisited;
    static String[] schools;
    static List<Edge>[] graph;

    static class Edge implements Comparable<Edge> {

        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        init();
        prim();
        print();
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학교의 수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수

        schools = br.readLine().split(" ");

        graph = new List[N];
        isVisited = new boolean[N];

        for (int n=0; n<N; n++) {
            graph[n] = new ArrayList<>();
        }

        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            if (!schools[u].equals(schools[v])) {
                graph[u].add(new Edge(v, d));
                graph[v].add(new Edge(u, d));
            }
        }
    }

    static void prim() {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int cur = e.to;
            int weight = e.weight;

            if (isVisited[cur]) continue;

            isVisited[cur] = true;
            ans += weight;
            cnt++;

            for (Edge next : graph[cur]) {
                if (!isVisited[next.to]) pq.offer(next);
            }
        }
    }

    static void print() {

        System.out.println(cnt == N ? ans : -1);
    }

}