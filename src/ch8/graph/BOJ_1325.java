package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n + 1];
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : arr[now]) {
                visited[i] = true;
                result[i]++; // 새로운 노드 인덱스의 정답 배열 값 증가
                queue.offer(i);
            }
        }
    }
}
