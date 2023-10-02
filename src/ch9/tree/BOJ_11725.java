package ch9.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {

    static int n;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int n) {
        visited[n] = true;
        for (int i : tree[n]) {
            if (!visited[i]) {
                answer[i] = n;
                dfs(i);
            }
        }
    }
}
