package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707 {
    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean[] visited;
    static boolean isBipartite;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr = new ArrayList[v + 1];
            check = new int[v + 1];
            visited = new boolean[v + 1];
            isBipartite = true;
            for (int i = 1; i <= v; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arr[start].add(end);
                arr[end].add(start);
            }
            for (int i = 1; i <= v; i++) {
                if (isBipartite) {
                    dfs(i);
                } else {
                    break;
                }
            }
            if (isBipartite) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        System.out.print(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int i : arr[node]) {
            if (!visited[i]) {
                // 인접한 노드는 같은 집합이 아니므로 이전 노드와 다르게
                check[i] = (check[node] + 1) % 2;
                dfs(i);
                // 이미 방문한 노드가 현재 노드와 같은 집합이면 false
            } else if (check[node] == check[i]) {
                isBipartite = false;
            }
        }
    }
}
