package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {

    static int V, E, K;
    static int distance[];
    static boolean visited[];
    static ArrayList<Edge> list[];
    static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // 가중치 있는 인접리스트
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        queue.add(new Edge(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentV = current.vertex;
            if (visited[currentV]) {
                continue;
            }
            visited[currentV] = true;
            for (int i = 0; i < list[currentV].size(); i++) {
                Edge temp = list[currentV].get(i);
                int next = temp.vertex;
                int value = temp.value;
                if (distance[next] > distance[currentV] + value) {
                    distance[next] = value + distance[currentV];
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int value;
    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        if (this.value > e.value) {
            return 1;
        } else {
            return -1;
        }
    }
}
