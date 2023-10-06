package ch9.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068 {

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int target = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int pNode = Integer.parseInt(st.nextToken());
            if (pNode != -1) {
                tree[i].add(pNode);
                tree[pNode].add(i);
            } else {
                root = i;
            }
        }
        target = Integer.parseInt(br.readLine());
        if (target == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(answer);
        }

    }

    public static void dfs(int number) {
        visited[number] = true;
        int cNode = 0;
        for (int i : tree[number]) {
            if (!visited[i] && target != i) {
                cNode++;
                dfs(i);
            }
        }
        if (cNode == 0) {
            answer++;
        }
    }
}
