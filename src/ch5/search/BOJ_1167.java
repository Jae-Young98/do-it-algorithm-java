package ch5.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1167 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        distance = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) {
                    break;
                }
                int v = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, v));
            }
        }
        bfs(1);

        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[n]);
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Node i : list[node]) {
                int e = i.e;
                int v = i.v;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.offer(e);
                    distance[e] = distance[node] + v;
                }
            }
        }
    }

    public static class Node {
        int e;
        int v;

        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }
}
