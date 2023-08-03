package ch5.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrive = false;
        list = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (arrive) {
                break;
            }
        }
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void dfs(int now, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int i : list[now]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}
