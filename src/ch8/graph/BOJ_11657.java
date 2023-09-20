package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {
    static int n, m;
    static long distance[];
    static Edge2 edges[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new Edge2[m + 1];
        distance = new long[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge2(start, end, time);
        }

        distance[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge2 edge2 = edges[j];
                if (distance[edge2.start] != Integer.MAX_VALUE && distance[edge2.end] > distance[edge2.start] + edge2.time) {
                    distance[edge2.end] = distance[edge2.start] + edge2.time;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < m; i++) {
            Edge2 edge2 = edges[i];
            if (distance[edge2.start] != Integer.MAX_VALUE && distance[edge2.end] > distance[edge2.start] + edge2.time) {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println(-1);
        }

    }
}

class Edge2 {
    int start, end, time;
    public Edge2(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
