package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197 {

    static int n, m;
    static int[] parent;
    static PriorityQueue<pEdge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i]= i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            queue.add(new pEdge(s, e, v));
        }

        int useEdge = 0;
        int result = 0;
        // 에지 - 1 만큼
        while (useEdge < n -1) {
            pEdge now = queue.poll();
            // 부모 노드가 다를때 (사이클 x)
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static class pEdge implements Comparable<pEdge> {
        int s;
        int e;
        int v;

        pEdge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(pEdge o) {
            // 가중치 오름차순으로 정렬
            return this.v - o.v;
        }
    }
}
