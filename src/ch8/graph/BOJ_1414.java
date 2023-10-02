package ch8.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1414 {

    static int n, sum;
    static int[] parent;
    static PriorityQueue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();
            for (int j = 0; j < n; j++) {
                int temp = 0;
                if (input[j] >= 'a' && input[j] <= 'z') {
                    temp = input[j] - 'a' + 1;
                } else if (input[j] >= 'A' && input[j] <= 'Z') {
                    temp = input[j] - 'A' + 27;
                }
                sum += temp;
                if (i != j && temp != 0) {
                    queue.add(new Node(i, j, temp));
                }
            }
        }
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }
        if (useEdge == n - 1) {
            System.out.println(sum - result);
        } else {
            System.out.println(-1);
        }

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int v;

        Node (int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }
}
