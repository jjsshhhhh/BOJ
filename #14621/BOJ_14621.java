import java.io.*;
import java.util.*;

public class BOJ_14621 {

    static int N, M, cnt = 0, ans = 0;
    static int[] parents;
    static String[] schools;
    static PriorityQueue<Edge> graph;

    static class Edge implements Comparable<Edge> {

        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
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
        kruskal();
        print();
    }

    static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학교의 수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수

        schools = br.readLine().split(" ");
        parents = new int[N];

        for (int n=0; n<N; n++) {
            parents[n] = n;
        }

        graph = new PriorityQueue<>();

        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            if (!schools[u].equals(schools[v]))
                graph.offer(new Edge(u, v, d));
        }
    }

    static void kruskal() {

        while (!graph.isEmpty()) {
            Edge e = graph.poll();
            int from = e.from;
            int to = e.to;
            int weight = e.weight;

            if (find(from) == find(to)) continue;

            union(from, to);
            ans += weight;
            cnt++;
        }
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX < parentY)
            parents[parentY] = parentX;
        else
            parents[parentX] = parentY;
    }

    static void print() {

        System.out.println(cnt == N-1 ? ans : -1);
    }

}


/*

1. 남초 대학교 - 여초 대학교 연결만 가능
2. 어떤 대학교에서든 모든 대학교로 이동 가능
3. 사심 경로의 길이는 최단 거리



 */