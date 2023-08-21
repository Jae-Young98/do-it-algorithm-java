package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352 {
    static int[] visited;
    static int n, m, k, x;
    static ArrayList<Integer>[] arr;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 노드
        m = Integer.parseInt(st.nextToken()); // 엣지
        k = Integer.parseInt(st.nextToken()); // 목표 거리
        x = Integer.parseInt(st.nextToken()); // 시작

        arr = new ArrayList[n+1];
        visited = new int[n+1];
        result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }
        bfs(x);

        for (int i = 0; i <= n; i++) {
            if (visited[i] == k) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(result);
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        visited[node]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : arr[now]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}
