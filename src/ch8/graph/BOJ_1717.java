package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    static int[] parent;
    static int a;
    static int b;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (c == 0) {
                union(a, b);
            } else {
                if (isUnion(a, b)) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }
        }
        System.out.print(sb);
    }

    public static int find (int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        } else {
            return false;
        }
    }
}
